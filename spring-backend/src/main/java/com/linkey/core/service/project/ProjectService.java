package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDto;
import com.linkey.core.domain.dto.request.ReqUpdateProjectDto;

import java.util.List;

public interface ProjectService {

    public List<ProjectDto> getProjectsByGithubUserId(Long githubUserId);

    public ProjectDto getProjectByProjectId(Integer projectId);

    public Integer createProject(ProjectDto projectDTO);

    public Integer updateProject(ReqUpdateProjectDto projectDTO);

    public Integer deleteProject(ProjectDto projectDTO);

}
