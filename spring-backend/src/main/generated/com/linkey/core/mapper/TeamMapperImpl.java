package com.linkey.core.mapper;

import com.linkey.core.domain.dto.request.ReqCreateTeamDto;
import com.linkey.core.domain.entity.Team;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-25T20:13:36+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public Team toEntity(ReqCreateTeamDto dto) {
        if ( dto == null ) {
            return null;
        }

        Team.TeamBuilder team = Team.builder();

        team.teamName( dto.getTeamName() );
        team.teamDesc( dto.getTeamDesc() );

        team.createdAt( java.time.LocalDateTime.now() );
        team.updatedAt( java.time.LocalDateTime.now() );

        return team.build();
    }
}
