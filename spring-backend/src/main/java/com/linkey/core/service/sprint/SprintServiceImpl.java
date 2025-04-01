package com.linkey.core.service.sprint;

import com.linkey.core.domain.dto.request.ReqCreateSprintDto;
import com.linkey.core.domain.dto.request.ReqUpdateSprintDto;
import com.linkey.core.domain.dto.response.ResSprintDetailDto;
import com.linkey.core.domain.dto.response.ResSprintListDto;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.domain.entity.Sprint;
import com.linkey.core.domain.entity.Todo;
import com.linkey.core.repository.project.ProjectRepository;
import com.linkey.core.repository.sprint.SprintRepository;
import com.linkey.core.repository.todo.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        long sprintId = reqUpdateSprintDto.getSprintId();
        Sprint existingSprint = repository.findById(sprintId)
                .orElseThrow(() -> new EntityNotFoundException("Sprint not found with id: " + sprintId));

        Sprint sprint = existingSprint.updateFromDto(reqUpdateSprintDto);

        repository.save(sprint);
        return sprintId;
    }

    // sprint 추가
    @Override
    public long addSprint(ReqCreateSprintDto reqCreateSprintDto) {
        int projectId = reqCreateSprintDto.getProject().getProjectId();
        Project project = projectRepo.findById(projectId)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Team not found: id=" + projectId
                        ));

        Sprint sprint = Sprint.builder()
                .sprintName(reqCreateSprintDto.getSprintName())
                .sprintContents(reqCreateSprintDto.getSprintContent())
                .sprintStartAt(reqCreateSprintDto.getSprintStartAt())
                .sprintEndAt(reqCreateSprintDto.getSprintEndAt())
                .project(project)
                .build();

        repository.save(sprint);
        return projectId;
    }

    // sprint 삭제
    @Override
    public long deleteSprint(Long sprintId) {
        repository.deleteById(sprintId);
        return sprintId;
    }

    // sprint 조회
    @Override
    public ResSprintDetailDto getSprintById(Long sprintId) {
        Sprint sprint = repository.findById(sprintId)
                .orElseThrow(() -> new EntityNotFoundException("Sprint not found with id: " + sprintId));
        List<Todo> todoList = todoRepo.findBySprint_SprintId(sprintId);
        return ResSprintDetailDto.fromEntity(sprint, todoList);
    }

    // sprint 목록 조회
    @Override
    public ResSprintListDto getSprintsByProjectId(Integer projectId) {
        Project project = new Project(projectId);
        List<Sprint> sprints = repository.findByProject(project);
        return ResSprintListDto.fromEntity(sprints);
    }

}
