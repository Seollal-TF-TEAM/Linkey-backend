package com.linkey.core.mapper;

import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.dto.request.ReqCreateTeamDto;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.domain.entity.TeamMember;
import com.linkey.core.global.config.MapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(config = MapperConfig.class)
public interface TeamMemberMapper {

    @Mapping(target = "user", expression = "java(new GitUser(dto.getGithubUserId()))")
    @Mapping(target = "team", source = "team")
    @Mapping(target = "memberId", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    TeamMember toEntity(ReqCreateTeamDto.SingleTeamMember dto, Team team);

    default List<TeamMember> toEntityList(List<ReqCreateTeamDto.SingleTeamMember> dtoList, Team team) {
        if (dtoList == null) return new ArrayList<>();
        return dtoList.stream()
                .map(dto -> toEntity(dto, team))
                .collect(Collectors.toList());
    }
}
