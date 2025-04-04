package com.linkey.core.service.project;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

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
    public ResProjectListDto getProjectsByGithubUserId(Long githubUserId) throws CustomException {
        try {
            List<Project> projects = projectRepo.findProjectsByGithubUserId(githubUserId);
            if (projects.isEmpty()) {
                throw new CustomException(ErrorCode.PROJECT_NOT_FOUND);
            }
            return ResProjectListDto.fromEntity(projects);
        } catch (CustomException e) {
            throw e;
        } catch (RuntimeException e) {
            throw new CustomException(ErrorCode.CAN_NOT_FIND_PROJECT);
        }
    }

    @Override
    public ResProjectDetailDto getProjectByProjectId(Integer projectId) throws CustomException{
        try {
            Project project = projectRepo.findById(projectId)
                    .orElseThrow(() -> new CustomException(ErrorCode.PROJECT_NOT_FOUND));
            return ResProjectDetailDto.fromEntity(project);
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_FIND_PROJECT);
        }
    }

    @Transactional
    @Override
    public Integer createProject(ReqCreateProjectDto projectDto) throws CustomException {
        try {
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
            return result.getProjectId();
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_CREATE_PROJECT);
        }
    }

    @Transactional
    @Override
    public Integer updateProject(ReqUpdateProjectDto projectDto) throws CustomException {
        try {
            Project target = projectRepo.findById(projectDto.getProjectId())
                    .orElseThrow(() -> new CustomException(ErrorCode.PROJECT_NOT_FOUND));
            Project updatedTarget = target.update(projectDto);
            projectRepo.save(updatedTarget);
            return target.getProjectId();
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_UPDATE_PROJECT);
        }
    }

    @Override
    public Integer deleteProject(int projectId) throws CustomException {
        try {
            Project target = projectRepo.findById(projectId)
                    .orElseThrow(() -> new CustomException(ErrorCode.PROJECT_NOT_FOUND));
            projectRepo.delete(target);
            return target.getProjectId();
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_DELETE_PROJECT);
        }
    }
}
