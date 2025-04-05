package com.linkey.core.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGitUser is a Querydsl query type for GitUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGitUser extends EntityPathBase<GitUser> {

    private static final long serialVersionUID = -1463908480L;

    public static final QGitUser gitUser = new QGitUser("gitUser");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath githubProfileUrl = createString("githubProfileUrl");

    public final StringPath githubReposUrl = createString("githubReposUrl");

    public final DateTimePath<java.time.LocalDateTime> githubUpdatedAt = createDateTime("githubUpdatedAt", java.time.LocalDateTime.class);

    public final StringPath githubUserEmail = createString("githubUserEmail");

    public final NumberPath<Long> githubUserId = createNumber("githubUserId", Long.class);

    public final StringPath githubUserName = createString("githubUserName");

    public final ListPath<TeamMember, QTeamMember> projects = this.<TeamMember, QTeamMember>createList("projects", TeamMember.class, QTeamMember.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QGitUser(String variable) {
        super(GitUser.class, forVariable(variable));
    }

    public QGitUser(Path<? extends GitUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGitUser(PathMetadata metadata) {
        super(GitUser.class, metadata);
    }

}

