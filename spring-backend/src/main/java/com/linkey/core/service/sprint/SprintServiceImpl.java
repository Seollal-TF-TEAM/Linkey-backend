package com.linkey.core.service.sprint;

import com.linkey.core.domain.dto.SprintDto;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.domain.entity.Sprint;
import com.linkey.core.repository.project.ProjectRepository;
import com.linkey.core.repository.sprint.SprintRepository;
import graphql.com.google.common.base.Optional;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class SprintServiceImpl implements SprintService {

    private final SprintRepository repository;
    private final ProjectRepository projectRepo;

    @Autowired
    SprintServiceImpl(SprintRepository repository, ProjectRepository projectRepo, ProjectRepository projectRepo1) {
        this.repository = repository;
        this.projectRepo = projectRepo;
    }

//    @Override
//    public List<SprintDto> getAllSprintsByProjectId(Integer projectId) {
//        List<Sprint> sprints = repository.findSprintsByProjectId(projectId);
//
//        return sprints.stream().map(SprintDto::fromEntity).toList();
//    }

    /*
    - Sprint insert 해야할 것
        - project id - fk
        - sprint name
        - sprint contents
        - sprint start at
        - sprint end at

    project id 포함해서 sprintDto만들어서 DB에 저장
    * */
    @Override
    public Boolean addSprint(Integer projectId, SprintDto sprintDto) {
        // project id 찾기 (조회)
//        Project project = projectRepo.findById(projectId).orElseThrow(() -> new IllegalArgumentException("Project not found"));
//
//        // sprint DTO를 엔티티로 변환한당
//        Sprint sprintEntity = Sprint.toEntity(sprintDto);
//        sprintEntity.setProject(project);
//        repository.save(sprintEntity);
//
//        return true;

        Project project = projectRepo.findById(projectId).orElseThrow(() -> new EntityNotFoundException("Team not found: id=" + projectId));;
        Sprint sprint = Sprint.builder()
                .sprintName(sprintDto.getSprintName())
                .sprintContents(sprintDto.getSprintContents())
                .sprintStartAt(sprintDto.getSprintStartAt())
                .sprintEndAt(sprintDto.getSprintEndAt())
                .build();

        repository.save(sprint);
        return true;
    }
}
