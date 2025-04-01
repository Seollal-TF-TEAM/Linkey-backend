package com.linkey.core.service.sprint;

import com.linkey.core.domain.dto.request.ReqCreateSprintDto;
import com.linkey.core.domain.dto.request.ReqUpdateSprintDto;
import com.linkey.core.domain.dto.response.ResSprintDetailDto;
import com.linkey.core.domain.dto.response.ResSprintListDto;

public interface SprintService {

    long createSprint(ReqCreateSprintDto reqCreateSprintDto);

    long updateSprint(ReqUpdateSprintDto reqUpdateSprintDto);

    long deleteSprint(Long sprintId);

    // sprint detail
    ResSprintDetailDto getSprintById(Long sprintId);

    // sprint list
    ResSprintListDto getSprintsByProjectId(Integer projectId);

//    List<SprintDto> findByProjectId(Integer projectId); // 프로젝트별 스프린트 조회 (필요한 경우)
}
