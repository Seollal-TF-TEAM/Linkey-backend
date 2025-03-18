package com.linkey.core.auth;

import com.linkey.core.domain.entity.GitUser;
import com.linkey.core.repository.GitUserRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth/github")
//@CrossOrigin(origins = "http://localhost:3000")
public class GitAuthController {

    private final String clientId = "Ov23liQoOCN40W8vsEU0"; // GitHub OAuth 앱에서 발급받은 Client ID
    private final String clientSecret = "d806a20481797f422c52d6c8dc40e5cd66b64eab"; // GitHub OAuth 앱에서 발급받은 Client Secret
    private final RestTemplate restTemplate = new RestTemplate();
    private final GitUserRepository gitUserRepository;

    public GitAuthController(GitUserRepository gitUserRepository) {
        this.gitUserRepository = gitUserRepository;
    }

    @GetMapping("/callback")
    public ResponseEntity<?> githubCallback(@RequestParam("code") String code) {
        System.out.println("Received GitHub OAuth Code: " + code);

        String accessToken = getAccessToken(code);
        if (accessToken == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to retrieve access token.");
        }
        System.out.println("GitHub Access Token: " + accessToken);

        // GitHub 사용자 정보 가져오기
        GitUser user = getGitUser(accessToken);
        System.out.println("GitHub User Info: " + user);

        // 유저 정보 DB 저장 (기존 유저 확인 후 업데이트)
        saveOrUpdateGitUser(user);

        Map<String, Object> response = new HashMap<>();
        response.put("user", user);

        System.out.println("res :" + response);
        return ResponseEntity.ok(response);
    }

    private String getAccessToken(String code) {
        String url = "https://github.com/login/oauth/access_token";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        Map<String, String> body = new HashMap<>();
        body.put("client_id", clientId);
        body.put("client_secret", clientSecret);
        body.put("code", code);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

        return response.getBody() != null ? (String) response.getBody().get("access_token") : null;
    }

    private GitUser getGitUser(String accessToken) {
        String url = "https://api.github.com/user";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        System.out.println("ACCESS_TOKEN : "+accessToken);
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);

        if (response.getBody() == null) {
            throw new RuntimeException("Failed to fetch GitHub user data.");
        }

        Map<String, Object> userData = response.getBody();

        GitUser user = new GitUser();
        user.setGithubUserId(Long.valueOf(userData.get("id").toString()));
        user.setGithubUserName(userData.get("login").toString());
        user.setGithubProfileUrl(userData.get("html_url").toString());
        user.setGithubReposUrl(userData.get("repos_url").toString());
        user.setGithubUpdatedAt(LocalDateTime.parse(userData.get("updated_at").toString().replace("Z", "")));
        user.setCreatedAt(LocalDateTime.parse(userData.get("created_at").toString().replace("Z", "")));
        user.setUpdatedAt(LocalDateTime.now());

        return user;
    }


    private void saveOrUpdateGitUser(GitUser user) {
        gitUserRepository.findById(user.getGithubUserId()).ifPresentOrElse(existingUser -> {
            // 기존 유저 정보 업데이트
            existingUser.setGithubUserName(user.getGithubUserName());
            existingUser.setGithubUserEmail(user.getGithubUserEmail());
            existingUser.setGithubProfileUrl(user.getGithubProfileUrl());
            existingUser.setGithubReposUrl(user.getGithubReposUrl());
            existingUser.setGithubUpdatedAt(user.getGithubUpdatedAt());
            existingUser.setUpdatedAt(LocalDateTime.now());
            gitUserRepository.save(existingUser);
        }, () -> {
            // 새로운 유저 저장
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());
            gitUserRepository.save(user);
        });
    }
}
