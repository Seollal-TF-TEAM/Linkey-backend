package com.linkey.core.repository.project.custom;

import com.linkey.core.domain.dto.ProjectDto;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.repository.project.ProjectRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {


    private final EntityManager em;

    protected ProjectRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<ProjectDto> findProectByGithubUserId(Long githubUserId) {
        return List.of();
    }
//    @Override
//    public List<Project> findByProjectId(Integer projectId) {
//        return List.of();
//    }
//
//    @Override
//    public List<Project> findProectByGithubUserId(Long githubUserId) {
//        return List.of();
//    }

}
