package com.linkey.core.repository.sprint.custom;

import com.linkey.core.domain.entity.QProject;
import com.linkey.core.domain.entity.QSprint;
import com.linkey.core.domain.entity.Sprint;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SprintRepositoryImpl implements SprintRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Sprint> findSprintsByProjectId(int projectId) {
        QSprint sprint = QSprint.sprint;
        QProject project = QProject.project;

        return queryFactory
                .selectFrom(sprint)
                .where(project.projectId.eq(projectId))
                .fetch();
    }
}
