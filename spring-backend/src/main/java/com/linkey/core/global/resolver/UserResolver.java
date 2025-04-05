package com.linkey.core.global.resolver;

import com.linkey.core.domain.entity.GitUser;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.repository.user.GitUserRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import static com.linkey.core.global.exception.ErrorCode.USER_NOT_FOUND;

@Component
public class UserResolver {
    private final RedisTemplate<String, GitUser> redisTemplate;
    private final GitUserRepository gitUserRepository;


    public UserResolver(RedisTemplate<String, GitUser> redisTemplate, GitUserRepository gitUserRepository) {
        this.redisTemplate = redisTemplate;
        this.gitUserRepository = gitUserRepository;
    }

    public GitUser getUserId(Long githubUserId){
        String redisKey = "githubUser:" + githubUserId;
        GitUser gitUser = redisTemplate.opsForValue().get(redisKey);

        if(gitUser != null){
            return gitUser;
        }
        gitUser = gitUserRepository.findByGithubUserId(githubUserId).orElseThrow(() -> new CustomException(USER_NOT_FOUND));

        return gitUser;
    }
}
