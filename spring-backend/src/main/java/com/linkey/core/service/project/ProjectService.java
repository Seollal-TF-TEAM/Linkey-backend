package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    public List<ProjectDTO> getProjectsByGithubUserId(Long githubUserId);

    public ProjectDTO getProjectByProjectId(Integer projectId);

    public Integer createProject(ProjectDTO projectDTO);

    public Integer updateProject(ProjectDTO projectDTO);

    public Integer deleteProject(ProjectDTO projectDTO);

}
