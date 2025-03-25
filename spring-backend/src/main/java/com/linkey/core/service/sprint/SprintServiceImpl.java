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
public class SprintServiceImpl implements SprintService {

    private final SprintRepository repository;
    private final ProjectRepository projectRepo;

    @Autowired
    SprintServiceImpl(SprintRepository repository, ProjectRepository projectRepo) {
        this.repository = repository;
        this.projectRepo = projectRepo;
    }

    @Override
    public Boolean addSprint(Integer projectId, SprintDto sprintDto) {

        Project project = projectRepo.findById(projectId).orElseThrow(() -> new EntityNotFoundException("Team not found: id=" + projectId));;
        Sprint sprint = Sprint.builder()
                .sprintName(sprintDto.getSprintName())
                .sprintContents(sprintDto.getSprintContents())
                .sprintStartAt(sprintDto.getSprintStartAt())
                .sprintEndAt(sprintDto.getSprintEndAt())
                .project(project)
                .build();

        repository.save(sprint);
        return true;
    }
}
