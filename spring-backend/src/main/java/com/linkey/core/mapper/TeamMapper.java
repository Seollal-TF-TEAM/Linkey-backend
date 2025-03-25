package com.linkey.core.mapper;

import com.linkey.core.domain.dto.request.ReqCreateTeamDto;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.global.config.MapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface TeamMapper {

    Team toEntity(ReqCreateTeamDto dto);
}
