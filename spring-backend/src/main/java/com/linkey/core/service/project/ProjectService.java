package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDto;

import java.util.List;

public interface ProjectService {

    public ProjectDto getUserProject(Integer projectId);

    public List<ProjectDto> getAllProjects(Long githubUserId);

    public boolean createProject(ProjectDto projectDto);
//    public
}
