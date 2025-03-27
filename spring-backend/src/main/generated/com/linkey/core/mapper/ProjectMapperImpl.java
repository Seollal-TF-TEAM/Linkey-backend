package com.linkey.core.mapper;

import com.linkey.core.domain.dto.request.ReqCreateProjectDto;
import com.linkey.core.domain.entity.Project;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-25T20:13:36+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public Project toEntity(ReqCreateProjectDto reqCreateProjectDto) {
        if ( reqCreateProjectDto == null ) {
            return null;
        }

        Project.ProjectBuilder project = Project.builder();

        project.projectName( reqCreateProjectDto.getProjectName() );
        project.projectDesc( reqCreateProjectDto.getProjectDesc() );
        project.githubRepoUrl( reqCreateProjectDto.getGithubRepoUrl() );

        project.team( new com.linkey.core.domain.entity.Team(dto.getTeam().getTeamId()) );

        return project.build();
    }
}
