package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDto;
import com.linkey.core.domain.dto.request.ReqCreateProjectDto;
import com.linkey.core.domain.dto.request.ReqUpdateProjectDto;
import com.linkey.core.domain.dto.response.ResProjectDetailDto;
import com.linkey.core.domain.dto.response.ResProjectListDto;

import java.util.List;

public interface ProjectService {

    public ResProjectListDto getProjectsByGithubUserId(Long githubUserId);

    public ResProjectDetailDto getProjectByProjectId(Integer projectId);

    public Integer createProject(ReqCreateProjectDto projectDTO);

    public Integer updateProject(ReqUpdateProjectDto projectDTO);

    public Integer deleteProject(int projectId);

}
