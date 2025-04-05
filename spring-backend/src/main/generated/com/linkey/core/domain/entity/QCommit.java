package com.linkey.core.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommit is a Querydsl query type for Commit
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommit extends EntityPathBase<Commit> {

    private static final long serialVersionUID = -294931436L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommit commit = new QCommit("commit");

    public final NumberPath<Integer> commitId = createNumber("commitId", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> githubCommitDate = createDateTime("githubCommitDate", java.time.LocalDateTime.class);

    public final StringPath githubCommitMessage = createString("githubCommitMessage");

    public final StringPath githubCommitSha = createString("githubCommitSha");

    public final NumberPath<Long> githubCommitUserId = createNumber("githubCommitUserId", Long.class);

    public final QTodo todo;

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QCommit(String variable) {
        this(Commit.class, forVariable(variable), INITS);
    }

    public QCommit(Path<? extends Commit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommit(PathMetadata metadata, PathInits inits) {
        this(Commit.class, metadata, inits);
    }

    public QCommit(Class<? extends Commit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.todo = inits.isInitialized("todo") ? new QTodo(forProperty("todo"), inits.get("todo")) : null;
    }

}

