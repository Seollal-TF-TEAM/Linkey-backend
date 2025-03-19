package com.linkey.core.repository;

import com.linkey.core.domain.entity.Project;

import java.util.List;

public abstract class ProjectRepositoryImpl implements ProjectRepository {

    @Override
    public Project findProjectByProjectId(Integer projectId) {
        return null;
    }

    @Override
    public List<Project> findProjectsByGithubUserId(Long githubUserId) {
        return List.of();
    }

}
