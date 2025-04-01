package com.linkey.core.repository.project;

import com.linkey.core.domain.entity.Project;
import com.linkey.core.repository.project.custom.ProjectRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer>, ProjectRepositoryCustom {

}
