package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDto;
import com.linkey.core.domain.dto.response.ResProjectDetailDto;
import com.linkey.core.domain.dto.response.ResProjectListDto;

import java.util.List;

public interface ProjectService {

    public ResProjectListDto getProjectsByGithubUserId(Long githubUserId);

    public ResProjectDetailDto getProjectByProjectId(Integer projectId);

    public Integer createProject(ProjectDto projectDTO);

    public Integer updateProject(ProjectDto projectDTO);

    public Integer deleteProject(ProjectDto projectDTO);

    public ResProjectListDto getProjectsByTeamId(Integer teamId);

}
