package com.linkey.core.repository;

import com.linkey.core.domain.entity.GitUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GitUserRepository extends JpaRepository<GitUser, Long> {
    Optional<GitUser> findByGithubUserName(String githubUserName);
}
