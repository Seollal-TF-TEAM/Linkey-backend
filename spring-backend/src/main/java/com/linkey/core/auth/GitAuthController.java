package com.linkey.core.auth;

import com.linkey.core.domain.dto.GitUser;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth/github")
@CrossOrigin(origins = "http://localhost:3000")
public class GitAuthController {

    private final String clientId = "Ov23liQoOCN40W8vsEU0"; // GitHub OAuth 앱에서 발급받은 Client ID
    private final String clientSecret = "d806a20481797f422c52d6c8dc40e5cd66b64eab"; // GitHub OAuth 앱에서 발급받은 Client Secret
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/callback")
    public ResponseEntity<?> githubCallback(@RequestParam("code") String code) {
        System.out.println("Received GitHub OAuth Code: " + code);

        String accessToken = getAccessToken(code);
        if (accessToken == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to retrieve access token.");
        }
        System.out.println("GitHub Access Token: " + accessToken);


        GitUser user = getGitUser(accessToken);
        System.out.println("GitHub User Info: " + user);

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

        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<GitUser> response = restTemplate.exchange(url, HttpMethod.GET, request, GitUser.class);

        return response.getBody();
    }
}
