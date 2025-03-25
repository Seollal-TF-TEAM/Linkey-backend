package com.linkey.core.mapper;

import com.linkey.core.domain.dto.request.ReqCreateSprintDto;
import com.linkey.core.domain.entity.Sprint;
import com.linkey.core.global.config.MapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(config = MapperConfig.class)
public interface SprintMapper {

    @Mapping(target = "project", expression = "java(new com.linkey.core.domain.entity.Project(dto.getProject().getProjectId()))")
    Sprint toEntity(ReqCreateSprintDto dto);

}
