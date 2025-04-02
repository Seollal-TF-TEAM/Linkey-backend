package com.linkey.core.repository.project;

import com.linkey.core.domain.entity.Project;
import com.linkey.core.repository.project.custom.ProjectRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer>, ProjectRepositoryCustom {

    Project findProjectByProjectId(Integer projectId);
    List<Project> findProjectsByProjectId(Integer projectId);
    List<Project> findProjectsByTeam_TeamId(Integer teamId);
    Project save(Project project);
//    @Query("select p from Project p "
//        + "join p.team t "
//        + "join t.teamMembers tm ON t.teamId = tm.team.teamId"
//        + ""
//    )
//    List<Project> findProjectByGithubUserId(Long githubUserId);
}
