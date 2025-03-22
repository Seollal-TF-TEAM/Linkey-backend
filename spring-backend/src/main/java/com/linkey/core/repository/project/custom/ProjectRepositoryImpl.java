package com.linkey.core.repository.project.custom;

import com.linkey.core.domain.dto.ProjectDto;
import com.linkey.core.domain.entity.Project;
//import com.linkey.core.domain.entity.QProject;
//import com.linkey.core.domain.entity.QTeam;
//import com.linkey.core.domain.entity.QTeamMember;
//import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

//    private final JPAQueryFactory queryFactory;

//    @Override
//    public List<ProjectDto> findProectByGithubUserId(Long githubUserId) {
//        return List.of();
//    }
//    @Override
//    public List<Project> findByProjectId(Integer projectId) {
//        return List.of();
//    }
//
    @Override
    public List<Project> findProectsByGithubUserId(Long githubUserId) {
//        QProject project = QProject.project;
//        QTeam team = QTeam.team;
//        QTeamMember teamMember = QTeamMember.teamMember;
//
//        List<Project> projects = queryFactory
//                .selectFrom(project)
//                .join(project.team, team)
//                .join(team.teamMembers, teamMember)
//                .where(teamMember.user.githubUserId.eq(githubUserId))
//                .fetch();
//
//        return projects.stream().map(ProjectDto::fromEntity).toList();
        return null;
    }

}
