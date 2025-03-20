package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDto;

import java.util.List;

public interface ProjectService {

    public List<ProjectDto> getUserProjects(Integer githubUserId);

    public void createProject(ProjectDto projectDto);
//    public
}
