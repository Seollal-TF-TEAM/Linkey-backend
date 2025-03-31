package com.linkey.core.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.linkey.core.domain.dto.response.ResCommitDto;
import com.linkey.core.domain.entity.GitUser;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/commits")
@RequiredArgsConstructor
public class CommitController {

    private final RedisTemplate<String, String> redisTemplate;
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{githubUserId}/{owner}/{repo}")
    public ResponseEntity<?> getCommits(
            @PathVariable Long githubUserId,
            @PathVariable String owner,
            @PathVariable String repo
    ) {
        String redisKey = "githubId:" + githubUserId;
        String token = redisTemplate.opsForValue().get(redisKey);

        // 로그인 필수 - token 없으면 X
        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }

        String url = String.format("https://api.github.com/repos/%s/%s/commits", owner, repo);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> request = new HttpEntity<>(headers);

        try {
            ResponseEntity<GitCommitRaw[]> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    request,
                    GitCommitRaw[].class
            );

            List<ResCommitDto> result = new ArrayList<>();
            for (GitCommitRaw raw : response.getBody()) {
                ResCommitDto dto = new ResCommitDto(
                        raw.getCommit().getMessage(), // message
                        raw.getAuthor().getLogin()    // login (GitHub ID)
                );
                result.add(dto);
            }

            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("커밋 조회 중 오류 발생: " + e.getMessage());
        }
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class GitCommitRaw {
        private Commit commit;
        private GithubUser author; // 👈 이름을 겹치지 않게!
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Commit {
        private Author author;
        private String message;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Author {
        private String name;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class GithubUser { // 👈 이름 변경
        private String login;
    }
}
