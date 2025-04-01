package com.linkey.core.service.sprint;

import com.linkey.core.domain.dto.request.ReqCreateSprintDto;
import com.linkey.core.domain.dto.request.ReqUpdateSprintDto;
import com.linkey.core.domain.dto.response.ResSprintDetailDto;
import com.linkey.core.domain.dto.response.ResSprintListDto;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.domain.entity.Sprint;
import com.linkey.core.domain.entity.Todo;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.global.exception.ErrorCode;
import com.linkey.core.repository.project.ProjectRepository;
import com.linkey.core.repository.sprint.SprintRepository;
import com.linkey.core.repository.todo.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class SprintServiceImpl implements SprintService {

    private final SprintRepository repository;
    private final ProjectRepository projectRepo;
    private final TodoRepository todoRepo;

    @Autowired
    SprintServiceImpl(SprintRepository repository, ProjectRepository projectRepo, TodoRepository todoRepo) {
        this.repository = repository;
        this.projectRepo = projectRepo;
        this.todoRepo = todoRepo;
    }

    // sprint 수정
    @Transactional
    @Override
    public long updateSprint(ReqUpdateSprintDto reqUpdateSprintDto) {
        try {
            long sprintId = reqUpdateSprintDto.getSprintId();
            Sprint existingSprint = repository.findById(sprintId)
                    .orElseThrow(() -> new CustomException(ErrorCode.SPRINT_NOT_FOUND));

            Sprint sprint = existingSprint.updateFromDto(reqUpdateSprintDto);

            repository.save(sprint);
            return sprintId;
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_UPDATE_SPRINT);
        }
    }

    // sprint 추가
    @Override
    public long createSprint(ReqCreateSprintDto reqCreateSprintDto) {
        try {
            int projectId = reqCreateSprintDto.getProject().getProjectId();
            Project project = projectRepo.findById(projectId)
                    .orElseThrow(() ->
                            new CustomException(ErrorCode.SPRINT_NOT_FOUND));

            Sprint sprint = Sprint.builder()
                    .sprintName(reqCreateSprintDto.getSprintName())
                    .sprintContents(reqCreateSprintDto.getSprintContent())
                    .sprintStartAt(reqCreateSprintDto.getSprintStartAt())
                    .sprintEndAt(reqCreateSprintDto.getSprintEndAt())
                    .project(project)
                    .build();

            repository.save(sprint);
            return projectId;
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_CREATE_SPRINT);
        }
    }

    // sprint 삭제
    @Override
    public long deleteSprint(Long sprintId) {
        try {
            Sprint target = repository.findById(sprintId)
                            .orElseThrow(() -> new CustomException(ErrorCode.SPRINT_NOT_FOUND));
            repository.deleteById(sprintId);
            return sprintId;
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_DELETE_SPRINT);
        }
    }

    // sprint 조회
    @Override
    public ResSprintDetailDto getSprintById(Long sprintId) {
        try {
            Sprint sprint = repository.findById(sprintId)
                    .orElseThrow(() -> new CustomException(ErrorCode.SPRINT_NOT_FOUND));
            List<Todo> todoList = todoRepo.findBySprint_SprintId(sprintId);
            return ResSprintDetailDto.fromEntity(sprint, todoList);
        } catch (Exception e) {
            throw new CustomException(ErrorCode.CAN_NOT_FIND_SPRINT);
        }
    }

    // sprint 목록 조회
    @Override
    public ResSprintListDto getSprintsByProjectId(Integer projectId) {
        try {
            List<Sprint> sprints = repository.findSprintsByProjectId(projectId);
            return ResSprintListDto.fromEntity(sprints);
        } catch (RuntimeException e) {
            throw new CustomException(ErrorCode.CAN_NOT_FIND_SPRINT);
        }
    }

}
