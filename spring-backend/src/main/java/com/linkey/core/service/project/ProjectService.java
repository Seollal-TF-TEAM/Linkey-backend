package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDto;
import com.linkey.core.domain.dto.request.ReqCreateProjectDto;
import com.linkey.core.domain.dto.request.ReqUpdateProjectDto;
import com.linkey.core.domain.dto.response.ResProjectDetailDto;
import com.linkey.core.domain.dto.response.ResProjectListDto;

public interface ProjectService {
    ResProjectListDto getProjectsByGithubUserId(Long githubUserId);
    ResProjectDetailDto getProjectByProjectId(Integer projectId);
    ProjectDto createProject(ReqCreateProjectDto projectDTO);
    ProjectDto updateProject(ReqUpdateProjectDto projectDTO);
    ProjectDto deleteProject(int projectId);
}
