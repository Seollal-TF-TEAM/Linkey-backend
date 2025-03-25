package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDto;
import com.linkey.core.domain.dto.request.ReqCreateProjectDto;
import com.linkey.core.domain.dto.request.ReqUpdateProjectDto;
import com.linkey.core.domain.dto.response.ResProjectDetailDto;
import com.linkey.core.domain.dto.response.ResProjectListDto;
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
    public ResProjectListDto getProjectsByGithubUserId(Long githubUserId) {
        List<Project> projects = repository.findProectsByGithubUserId(githubUserId);

        return ResProjectListDto.fromEntity(projects);
    }


    @Override
    public ResProjectDetailDto getProjectByProjectId(Integer projectId) {
        Optional<Project> project = repository.findById(projectId);

        return ResProjectDetailDto.fromEntity(project.get());
    }


    @Override
    public Integer createProject(ReqCreateProjectDto projectDto) {

        Project project = new Project(
                projectDto.getProjectName(),
                projectDto.getProjectDesc(),
                new Team(projectDto.getTeam().getTeamId()),
                projectDto.getGithubRepoUrl()
        );
        Project result = repository.save(project);
        return result.getProjectId();
    }

    @Override
    public Integer updateProject(ReqUpdateProjectDto projectDTO) {
        return 0;
    }

    @Override
    public Integer deleteProject(int projectId) {
        return 0;
    }


}
