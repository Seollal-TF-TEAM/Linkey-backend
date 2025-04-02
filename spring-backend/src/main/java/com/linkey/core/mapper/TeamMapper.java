package com.linkey.core.mapper;

import com.linkey.core.domain.dto.request.ReqCreateTeamDto;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.global.config.MapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" ,config = MapperConfig.class)
public interface TeamMapper {
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "teamId", ignore = true) // 👈 teamMembers는 나중에 따로 채움
    Team toEntity(ReqCreateTeamDto dto);
}
