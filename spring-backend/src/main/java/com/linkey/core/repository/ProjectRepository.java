package com.linkey.core.repository;

import com.linkey.core.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("select p from Project p "
        + "join p.team t "
        + "join t.teamMembers tm ON t.teamId = tm.team.teamId"
        + ""
    )
    List<Project> findByUserId(Long githubUserId);
}
