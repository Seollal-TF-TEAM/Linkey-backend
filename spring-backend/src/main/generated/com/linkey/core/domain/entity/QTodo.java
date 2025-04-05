package com.linkey.core.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTodo is a Querydsl query type for Todo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTodo extends EntityPathBase<Todo> {

    private static final long serialVersionUID = -1210972573L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTodo todo = new QTodo("todo");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final QGitUser createdUser;

    public final QSprint sprint;

    public final StringPath todoContents = createString("todoContents");

    public final ComparablePath<Character> todoDoneYn = createComparable("todoDoneYn", Character.class);

    public final NumberPath<Long> todoId = createNumber("todoId", Long.class);

    public final EnumPath<com.linkey.core.domain.enums.TodoLevel> todoLevel = createEnum("todoLevel", com.linkey.core.domain.enums.TodoLevel.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QTodo(String variable) {
        this(Todo.class, forVariable(variable), INITS);
    }

    public QTodo(Path<? extends Todo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTodo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTodo(PathMetadata metadata, PathInits inits) {
        this(Todo.class, metadata, inits);
    }

    public QTodo(Class<? extends Todo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdUser = inits.isInitialized("createdUser") ? new QGitUser(forProperty("createdUser")) : null;
        this.sprint = inits.isInitialized("sprint") ? new QSprint(forProperty("sprint"), inits.get("sprint")) : null;
    }

}

