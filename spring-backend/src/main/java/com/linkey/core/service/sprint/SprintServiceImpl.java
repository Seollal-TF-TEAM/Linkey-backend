package com.linkey.core.service.sprint;

import com.linkey.core.domain.dto.SprintDto;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.domain.entity.Sprint;
import com.linkey.core.repository.project.ProjectRepository;
import com.linkey.core.repository.sprint.SprintRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class SprintServiceImpl implements SprintService {

    private final SprintRepository repository;
    private final ProjectRepository projectRepo;

    @Autowired
    SprintServiceImpl(SprintRepository repository, ProjectRepository projectRepo) {
        this.repository = repository;
        this.projectRepo = projectRepo;
    }

    // update sprint
    @Transactional
    @Override
    public Boolean updateSprint(Long sprintId, SprintDto sprintDto) {
        Sprint existingSprint = repository.findById(sprintId)
                .orElseThrow(() -> new EntityNotFoundException("Sprint not found with id: " + sprintId));

        existingSprint.updateFromDto(sprintDto);
        return true;
    }

    @Override
    public Boolean addSprint(Integer projectId, SprintDto sprintDto) {
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new EntityNotFoundException("Team not found: id=" + projectId));

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
