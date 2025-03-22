package com.linkey.core.repository.project.custom;

import com.linkey.core.domain.entity.Project;

import java.util.List;

public interface ProjectRepositoryCustom {
    List<Project> findProectsByGithubUserId(Long githubUserId);

}
