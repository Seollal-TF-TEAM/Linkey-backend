package com.linkey.core.mapper;

import com.linkey.core.domain.dto.request.ReqCreateCommitDto;
import com.linkey.core.domain.entity.Commit;
import com.linkey.core.global.config.MapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CommitMapper {

    Commit toEntity(ReqCreateCommitDto reqCreateCommitDto);
}
