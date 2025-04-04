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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public ResProjectListDto getProjectsByGithubUserId(Long githubUserId) throws CustomException {
        try {
            List<Project> projects = repository.findProjectsByGithubUserId(githubUserId);
            return ResProjectListDto.fromEntity(projects);
        } catch (RuntimeException e) {
            throw new CustomException(ErrorCode.CAN_NOT_FIND_PROJECT);
        }
    }

    @Override
    public ResProjectDetailDto getProjectByProjectId(Integer projectId) throws CustomException{
        try {
            Optional<Project> project = repository.findById(projectId);
            return project.map(ResProjectDetailDto::fromEntity).orElse(null);
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_FIND_PROJECT);
        }
    }

    @Override
    public Integer createProject(ReqCreateProjectDto projectDto) throws CustomException {
        try {
            Project result = repository.save(Project.builder()
                    .projectName(projectDto.getProjectName())
                    .projectDesc(projectDto.getProjectDesc())
                    .team(
                            Team.builder()
                                    .teamId(projectDto.getTeam().getTeamId())
                                    .build()
                    ).githubRepoUrl(projectDto.getGithubRepoUrl())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build()
            );
            return result.getProjectId();
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_CREATE_PROJECT);
        }
    }

    @Override
    public Integer updateProject(ReqUpdateProjectDto projectDto) throws CustomException {
        try {
            Project target = repository.findById(projectDto.getProjectId())
                    .orElseThrow(() -> new CustomException(ErrorCode.PROJECT_NOT_FOUND));
            Project updatedTarget = target.update(projectDto);
            updatedTarget.preUpdate();
            repository.save(updatedTarget);
            return target.getProjectId();
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_UPDATE_PROJECT);
        }
    }

    @Override
    public Integer deleteProject(int projectId) throws CustomException {
        try {
            Project target = repository.findById(projectId)
                    .orElseThrow(() -> new CustomException(ErrorCode.PROJECT_NOT_FOUND));
            repository.delete(target);
            return target.getProjectId();
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_DELETE_PROJECT);
        }
    }
}
