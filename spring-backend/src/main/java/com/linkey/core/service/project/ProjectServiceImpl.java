package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDto;
import com.linkey.core.domain.dto.request.ReqCreateProjectDto;
import com.linkey.core.domain.dto.request.ReqUpdateProjectDto;
import com.linkey.core.domain.dto.response.ResProjectDetailDto;
import com.linkey.core.domain.dto.response.ResProjectListDto;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.global.exception.ErrorCode;
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

        return project.map(ResProjectDetailDto::fromEntity).orElse(null);
    }


    @Override
    public Integer createProject(ReqCreateProjectDto projectDto) {

        Project result = repository.save(Project.builder()
                .projectName(projectDto.getProjectName())
                .projectDesc(projectDto.getProjectDesc())
                .team(
                        Team.builder()
                                .teamId(projectDto.getTeam().getTeamId())
                                .build()
                ).githubRepoUrl(projectDto.getGithubRepoUrl())
                .build()
        );

        return result.getProjectId();
    }

    @Override
    public Integer updateProject(ReqUpdateProjectDto projectDto) throws CustomException {

        Optional<Project> target = repository.findById(
                projectDto.getProjectId()
        );

        if (target.isEmpty()) {
            throw new CustomException(ErrorCode.PROJECT_NOT_FOUND);
        }

        Project result = repository.save(Project.builder()
                .projectName(projectDto.getProjectName())
                .projectDesc(projectDto.getProjectDesc())
                .githubRepoUrl(projectDto.getGithubRepoUrl())
                .build()
        );

        return result.getProjectId();
    }

    @Override
    public Integer deleteProject(int projectId) throws CustomException {

        Optional<Project> target = repository.findById(projectId);

        if (target.isEmpty()) {
            throw new CustomException(ErrorCode.PROJECT_NOT_FOUND);
        }

        repository.delete(target.get());

        return target.get().getProjectId();
    }
}
