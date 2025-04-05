package com.linkey.core.repository.user;

import com.linkey.core.domain.entity.GitUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface GitUserRepository extends JpaRepository<GitUser, Long> {
    Optional<GitUser> findByGithubUserId(Long githubUserId);
    boolean existsByGithubUserId(Long githubUserId);
    List<GitUser> findByGithubUserNameContainingIgnoreCase(String keyword);
}
