package com.linkey.core.service.project;

import com.linkey.core.domain.dto.request.ReqCreateProjectDto;
import com.linkey.core.domain.dto.request.ReqUpdateProjectDto;
import com.linkey.core.domain.dto.response.ResProjectDetailDto;
import com.linkey.core.domain.dto.response.ResProjectListDto;

public interface ProjectService {
    ResProjectListDto getProjectsByGithubUserId(Long githubUserId);
    ResProjectDetailDto getProjectByProjectId(Integer projectId);
    Integer createProject(ReqCreateProjectDto projectDTO);
    Integer updateProject(ReqUpdateProjectDto projectDTO);
    Integer deleteProject(int projectId);
}
