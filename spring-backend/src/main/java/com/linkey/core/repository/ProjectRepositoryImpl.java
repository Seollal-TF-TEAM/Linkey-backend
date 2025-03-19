package com.linkey.core.repository;

import com.linkey.core.domain.entity.Project;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class ProjectRepositoryImpl implements ProjectRepository {

    @Override
    public List<Project> findByProjectId(Integer projectId) {
        return List.of();
    }

    @Override
    public List<Project> findProectByGithubUserId(Long githubUserId) {
        return List.of();
    }

}
