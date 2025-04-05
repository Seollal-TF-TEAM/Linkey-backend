package com.linkey.core.mapper;

import com.linkey.core.domain.dto.request.ReqCreateSprintDto;
import com.linkey.core.domain.entity.Sprint;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-25T20:13:36+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class SprintMapperImpl implements SprintMapper {

    @Override
    public Sprint toEntity(ReqCreateSprintDto dto) {
        if ( dto == null ) {
            return null;
        }

        Sprint.SprintBuilder sprint = Sprint.builder();

        sprint.sprintName( dto.getSprintName() );
        sprint.sprintContents( dto.getSprintContents() );
        sprint.sprintStartAt( dto.getSprintStartAt() );
        sprint.sprintEndAt( dto.getSprintEndAt() );

        sprint.project( new com.linkey.core.domain.entity.Project(dto.getProject().getProjectId()) );

        return sprint.build();
    }
}
