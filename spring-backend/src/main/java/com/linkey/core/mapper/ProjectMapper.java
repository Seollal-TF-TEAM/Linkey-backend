package com.linkey.core.mapper;

import com.linkey.core.domain.dto.request.ReqCreateProjectDto;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.global.config.MapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface ProjectMapper {

    @Mapping(target ="team", expression="java(new com.linkey.core.domain.entity.Team(dto.getTeam().getTeamId()))")
    Project toEntity(ReqCreateProjectDto reqCreateProjectDto);

}
