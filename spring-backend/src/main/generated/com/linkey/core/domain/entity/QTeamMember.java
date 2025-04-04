package com.linkey.core.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeamMember is a Querydsl query type for TeamMember
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeamMember extends EntityPathBase<TeamMember> {

    private static final long serialVersionUID = 164205492L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTeamMember teamMember = new QTeamMember("teamMember");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> memberId = createNumber("memberId", Integer.class);

    public final EnumPath<com.linkey.core.domain.enums.MemberRole> memberRole = createEnum("memberRole", com.linkey.core.domain.enums.MemberRole.class);

    public final QTeam team;

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final QGitUser user;

    public QTeamMember(String variable) {
        this(TeamMember.class, forVariable(variable), INITS);
    }

    public QTeamMember(Path<? extends TeamMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTeamMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTeamMember(PathMetadata metadata, PathInits inits) {
        this(TeamMember.class, metadata, inits);
    }

    public QTeamMember(Class<? extends TeamMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.team = inits.isInitialized("team") ? new QTeam(forProperty("team")) : null;
        this.user = inits.isInitialized("user") ? new QGitUser(forProperty("user")) : null;
    }

}

