package com.linkey.core.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSprint is a Querydsl query type for Sprint
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSprint extends EntityPathBase<Sprint> {

    private static final long serialVersionUID = 164203767L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSprint sprint = new QSprint("sprint");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final QProject project;

    public final StringPath sprintContents = createString("sprintContents");

    public final DatePath<java.time.LocalDate> sprintEndAt = createDate("sprintEndAt", java.time.LocalDate.class);

    public final NumberPath<Long> sprintId = createNumber("sprintId", Long.class);

    public final StringPath sprintName = createString("sprintName");

    public final DatePath<java.time.LocalDate> sprintStartAt = createDate("sprintStartAt", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QSprint(String variable) {
        this(Sprint.class, forVariable(variable), INITS);
    }

    public QSprint(Path<? extends Sprint> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSprint(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSprint(PathMetadata metadata, PathInits inits) {
        this(Sprint.class, metadata, inits);
    }

    public QSprint(Class<? extends Sprint> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.project = inits.isInitialized("project") ? new QProject(forProperty("project"), inits.get("project")) : null;
    }

}

