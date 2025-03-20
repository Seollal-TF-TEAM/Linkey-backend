package com.linkey.core.repository.user;

import com.linkey.core.domain.entity.GitUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface GitUserRepository extends JpaRepository<GitUser, Long> {
    Optional<GitUser> findByGithubUserName(String githubUserName);
}
