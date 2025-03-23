package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDto;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.repository.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;

    @Autowired
    ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<ProjectDto> getProjectsByGithubUserId(Long githubUserId) {
        List<Project> projects = repository.findProectsByGithubUserId(githubUserId);

        return projects.stream()
                    .map(ProjectDto::fromEntity)
                    .toList();
    }


    @Override
    public ProjectDto getProjectByProjectId(Integer projectId) {
        Optional<Project> project = repository.findById(projectId);

        return ProjectDto.fromEntity(project.get());
    }


    @Override
    public Integer createProject(ProjectDto projectDto) {

        Project project = new Project(
                projectDto.getProjectName(),
                projectDto.getProjectDesc(),
                new Team(projectDto.getTeamId()),
                projectDto.getGithubRepoUrl()
        );
        Project result = repository.save(project);
        return result.getProjectId();
    }

    @Override
    public Integer updateProject(ProjectDto projectDTO) {
        return 0;
    }

    @Override
    public Integer deleteProject(ProjectDto projectDTO) {
        return 0;
    }


}
