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

import java.util.List;
import java.util.Optional;

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

    // sprint 수정
    @Transactional
    @Override
    public Boolean updateSprint(Long sprintId, SprintDto sprintDto) {
        Sprint existingSprint = repository.findById(sprintId)
                .orElseThrow(() -> new EntityNotFoundException("Sprint not found with id: " + sprintId));

        existingSprint.updateFromDto(sprintDto);
        return true;
    }

    // sprint 추가
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

    // sprint 삭제
    @Override
    public Boolean deleteSprint(Long sprintId) {
        repository.deleteById(sprintId);
        return true;
    }

    // sprint 조회
    @Override
    public SprintDto getSprintById(Long sprintId) {
        Sprint sprint = repository.findById(sprintId)
                .orElseThrow(() -> new EntityNotFoundException("Sprint not found with id: " + sprintId));
        return SprintDto.fromEntity(sprint);
//        Optional<Sprint> sprint = repository.findById(sprintId);
//        assert sprint.orElse(null) != null;
//        return SprintDto.fromEntity(sprint.orElse(null));
    }

    // sprint 목록 조회 - project id 사용해서 sprint 전부 가져오기
    @Override
    public List<SprintDto> getSprintsByProjectId(Integer projectId) {
        List<Sprint> sprints = repository.findByProjectId(projectId); // project id로 sprint 목록 가져오기
        return sprints.stream().map(SprintDto::fromEntity).toList();
    }
}
