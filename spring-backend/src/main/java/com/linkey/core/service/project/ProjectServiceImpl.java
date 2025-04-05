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
import com.linkey.core.repository.team.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepo;
    private final TeamRepository teamRepo;

    @Autowired
    ProjectServiceImpl(ProjectRepository repository, TeamRepository teamRepo) {
        this.projectRepo = repository;
        this.teamRepo = teamRepo;
    }

    @Override
    public ResProjectListDto getProjectsByGithubUserId(Long githubUserId) {
        List<Project> projects = projectRepo.findProjectsByGithubUserId(githubUserId);
        if (projects.isEmpty()) {
            throw new CustomException(ErrorCode.PROJECT_NOT_FOUND);
        }
        return ResProjectListDto.fromEntity(projects);
    }

    @Override
    public ResProjectDetailDto getProjectByProjectId(Integer projectId) {
        return ResProjectDetailDto.fromEntity(projectRepo.findById(projectId)
                .orElseThrow(() -> new CustomException(ErrorCode.PROJECT_NOT_FOUND))
        );
    }

    @Override
    public ResProjectListDto getProjectsByTeamId(Integer teamId) throws CustomException {
        try{
            Optional<List<Project>> projects= Optional.ofNullable((projectRepo.findProjectsByTeam_TeamId(teamId)));
            List<Project> projectEntities = projects.orElseThrow(() -> new CustomException(ErrorCode.CAN_NOT_FIND_PROJECT));

            return ResProjectListDto.fromEntity(projectEntities);
        }catch (CustomException e){
            throw e;
        }catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_FIND_PROJECT);
        }


//        return projectEntities.stream().map(ProjectDto::fromEntity).toList();
    }

    public ProjectDto createProject(ReqCreateProjectDto projectDto) {
        Team team = teamRepo.findById(projectDto.getTeam().getTeamId())
                .orElseThrow(() -> new CustomException(ErrorCode.TEAM_NOT_FOUND));
        Project result = projectRepo.save(Project.builder()
                .projectName(projectDto.getProjectName())
                .projectDesc(projectDto.getProjectDesc())
                .team(team)
                .githubRepoUrl(projectDto.getGithubRepoUrl())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build()
        );
        return ProjectDto.fromEntity(result);
    }

    @Transactional
    @Override
    public ProjectDto updateProject(ReqUpdateProjectDto projectDto) {
        Project target = projectRepo.findById(projectDto.getProjectId())
                .orElseThrow(() -> new CustomException(ErrorCode.PROJECT_NOT_FOUND));
        Project updatedTarget = target.update(projectDto);
        projectRepo.save(updatedTarget);
        return ProjectDto.fromEntity(updatedTarget);
    }

    @Override
    public ProjectDto deleteProject(int projectId) {
        Project target = projectRepo.findById(projectId)
                .orElseThrow(() -> new CustomException(ErrorCode.PROJECT_NOT_FOUND));
        projectRepo.delete(target);
        return ProjectDto.fromEntity(target);
    }
}
