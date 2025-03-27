package com.linkey.core.repository.project;

import com.linkey.core.domain.dto.ProjectDto;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.repository.project.custom.ProjectRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer>, ProjectRepositoryCustom {

}
