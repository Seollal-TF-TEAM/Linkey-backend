package com.linkey.core.repository.project;

import com.linkey.core.domain.entity.Project;
import com.linkey.core.repository.project.custom.ProjectRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer>, ProjectRepositoryCustom {

    List<Project> findByProjectId(Integer projectId);

//    @Query("select p from Project p "
//        + "join p.team t "
//        + "join t.teamMembers tm ON t.teamId = tm.team.teamId"
//        + ""
//    )
//    List<Project> findProectByGithubUserId(Long githubUserId);
}
