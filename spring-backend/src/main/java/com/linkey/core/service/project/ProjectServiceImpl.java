package com.linkey.core.service.project;

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
    public List<Project> getUserProjects(Integer projectId) {
        List<Project> projects = repository.findByProjectId(projectId);

        return projects;
    }


}
