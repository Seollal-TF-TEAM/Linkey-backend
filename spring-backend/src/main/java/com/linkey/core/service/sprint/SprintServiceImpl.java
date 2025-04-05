package com.linkey.core.service.sprint;

import com.linkey.core.domain.dto.SprintDto;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class SprintServiceImpl implements SprintService {

    private final SprintRepository SprintRepo;
    private final ProjectRepository projectRepo;
    private final TodoRepository todoRepo;

    @Autowired
    SprintServiceImpl(SprintRepository repository,
                      ProjectRepository projectRepo,
                      TodoRepository todoRepo) {
        this.SprintRepo = repository;
        this.projectRepo = projectRepo;
        this.todoRepo = todoRepo;
    }

    // sprint 수정
    @Transactional
    @Override
    public SprintDto updateSprint(ReqUpdateSprintDto reqUpdateSprintDto) throws CustomException {
        long sprintId = reqUpdateSprintDto.getSprintId();
        Sprint existingSprint = SprintRepo.findById(sprintId)
                .orElseThrow(() -> new CustomException(ErrorCode.SPRINT_NOT_FOUND));
        int dateDiff = reqUpdateSprintDto.getSprintEndAt().compareTo(
                reqUpdateSprintDto.getSprintStartAt()
        );
        if (dateDiff < 0) {
            throw new CustomException(ErrorCode.SPRINT_END_DATE_IS_INVALID);
        }
        Sprint sprint = existingSprint.update(reqUpdateSprintDto);
        SprintRepo.save(sprint);
        return SprintDto.fromEntity(sprint);
    }

    // sprint 추가
    @Transactional
    @Override
    public SprintDto createSprint(ReqCreateSprintDto reqCreateSprintDto) {
        int projectId = reqCreateSprintDto.getProject().getProjectId();
        Project project = projectRepo.findById(projectId)
                .orElseThrow(() -> new CustomException(ErrorCode.SPRINT_NOT_FOUND));
        int dateDiff = reqCreateSprintDto.getSprintEndAt().compareTo(
                reqCreateSprintDto.getSprintStartAt()
        );
        if (dateDiff < 0) {
            throw new CustomException(ErrorCode.SPRINT_END_DATE_IS_INVALID);
        }
        Sprint sprint = Sprint.builder()
                .sprintName(reqCreateSprintDto.getSprintName())
                .sprintContents(reqCreateSprintDto.getSprintContent())
                .sprintStartAt(reqCreateSprintDto.getSprintStartAt())
                .sprintEndAt(reqCreateSprintDto.getSprintEndAt())
                .project(project)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        SprintRepo.save(sprint);
        return SprintDto.fromEntity(sprint);
    }

    // sprint 삭제
    @Transactional
    @Override
    public SprintDto deleteSprint(Long sprintId) {
        Sprint target = SprintRepo.findById(sprintId)
                        .orElseThrow(() -> new CustomException(ErrorCode.SPRINT_NOT_FOUND));
        SprintRepo.delete(target);
        return SprintDto.fromEntity(target);
    }

    // sprint 조회
    @Override
    public ResSprintDetailDto getSprintById(Long sprintId) {
        Sprint sprint = SprintRepo.findById(sprintId)
                .orElseThrow(() -> new CustomException(ErrorCode.SPRINT_NOT_FOUND));
        List<Todo> todoList = todoRepo.findBySprint_SprintId(sprintId);
        return ResSprintDetailDto.fromEntity(sprint, todoList);
    }

    // sprint 목록 조회
    @Override
    public ResSprintListDto getSprintsByProjectId(Integer projectId) {
        List<Sprint> sprints = SprintRepo.findSprintsByProjectId(projectId);
        if (sprints.isEmpty()) {
            throw new CustomException(ErrorCode.SPRINT_NOT_FOUND);
        }
        return ResSprintListDto.fromEntity(sprints);
    }
}
