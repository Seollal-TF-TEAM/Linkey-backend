package com.linkey.core.mapper;

import com.linkey.core.domain.dto.request.ReqCreateTeamDto;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.domain.entity.TeamMember;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-25T20:13:36+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class TeamMemberMapperImpl implements TeamMemberMapper {

    @Override
    public TeamMember toEntity(ReqCreateTeamDto.SingleTeamMember dto, Team team) {
        if ( dto == null && team == null ) {
            return null;
        }

        TeamMember.TeamMemberBuilder teamMember = TeamMember.builder();

        teamMember.team( team );
        teamMember.user( new GitUser(dto.getGithubUserId()) );
        teamMember.createdAt( java.time.LocalDateTime.now() );
        teamMember.updatedAt( java.time.LocalDateTime.now() );

        return teamMember.build();
    }
}
