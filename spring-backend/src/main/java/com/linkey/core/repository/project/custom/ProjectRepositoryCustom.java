package com.linkey.core.repository.project.custom;

import com.linkey.core.domain.dto.ProjectDto;

import java.util.List;

public interface ProjectRepositoryCustom {

    List<ProjectDto> findProectByGithubUserId(Long githubUserId);

}
