package com.linkey.core.repository.image.custom;

import com.linkey.core.domain.entity.Image;
import com.linkey.core.domain.entity.QImage;
import com.linkey.core.domain.entity.QProject;
import com.linkey.core.domain.entity.QSprint;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ImageRepositoryImpl implements ImageRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Image> findImagesByProjectId(int projectId) {
        QImage image = QImage.image;
        QProject project = QProject.project;

        return queryFactory
                .selectFrom(image)
                .where(project.projectId.eq(projectId))
                .fetch();
    }

    @Override
    public List<Image> findImagesBySprintId(long sprintId) {
        QImage image = QImage.image;
        QSprint sprint = QSprint.sprint;

        return queryFactory
                .selectFrom(image)
                .where(sprint.sprintId.eq(sprintId))
                .fetch();
    }
}
