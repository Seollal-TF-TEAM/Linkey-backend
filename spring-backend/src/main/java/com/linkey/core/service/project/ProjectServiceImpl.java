package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDTO;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;

    ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<ProjectDTO> getProjectsByGithubUserId(Long githubUserId) {
        List<Project> projects = repository.findProjectsByGithubUserId(githubUserId);

        return projects.stream()
                    .map(ProjectDTO::toDTO)
                    .toList();
    }


    @Override
    public ProjectDTO getProjectByProjectId(Integer projectId) {
        Project project = repository.findProjectByProjectId(projectId);

        return ProjectDTO.toDTO(project);
    }


    @Override
    public Integer createProject(ProjectDTO projectDTO) {
        return 0;
    }

    @Override
    public Integer updateProject(ProjectDTO projectDTO) {
        return 0;
    }

    @Override
    public Integer deleteProject(ProjectDTO projectDTO) {
        return 0;
    }


}
