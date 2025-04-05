package com.linkey.core.service.user;

import com.linkey.core.domain.dto.GitUserDto;
import com.linkey.core.repository.user.GitUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final GitUserRepository gitUserRepository;

    public  UserServiceImpl(RedisTemplate<String, String> redisTemplate, GitUserRepository gitUserRepository) {
        this.gitUserRepository = gitUserRepository;
    }

    @Override
    public List<GitUserDto> searchUsersByKeyword(String keyword) {
        return gitUserRepository.findByGithubUserNameContainingIgnoreCase(keyword)
                .stream()
                .map(GitUserDto::fromEntity)
                .toList();
    }
}
