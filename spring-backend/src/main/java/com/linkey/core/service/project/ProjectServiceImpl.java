package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDTO;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;

    ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<ProjectDTO> getUserProjects(Integer projectId) {
        List<Project> projects = repository.findByProjectId(projectId);

        return projects.stream()
                    .map(ProjectDTO::toDTO)
                    .toList();
    }


}
