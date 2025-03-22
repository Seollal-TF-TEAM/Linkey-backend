package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDto;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.repository.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;

    @Autowired
    ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }


    @Override
    public ProjectDto getUserProject(Integer projectId) {
        Project project = repository.findProjectByProjectId(projectId);

        return ProjectDto.fromEntity(project);
    }

    @Override
    public List<ProjectDto> getAllProjects(Long githubUserId) {
        List<ProjectDto> projects = repository.findProectByGithubUserId(githubUserId);

        return List.of();
    }


    @Override
    public boolean createProject(ProjectDto projectDto){


        return false;
    }


}
