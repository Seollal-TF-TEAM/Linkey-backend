package com.linkey.core.mapper;

import com.linkey.core.domain.dto.request.ReqCreateTeamDto;
import com.linkey.core.domain.dto.request.ReqCreateTodoDto;
import com.linkey.core.domain.entity.Todo;
import org.mapstruct.Mapping;

public interface TodoMapper {

    @Mapping(target = "todoDoneYn", constant = "N")
    @Mapping(target = "createdUser", expression = "java(new GitUser(dto.getGithubUserId()))")
    Todo toEntity(ReqCreateTodoDto dto);
}