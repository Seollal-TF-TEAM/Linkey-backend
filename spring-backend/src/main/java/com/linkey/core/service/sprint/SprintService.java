package com.linkey.core.service.sprint;

import com.linkey.core.domain.dto.request.ReqCreateSprintDto;
import com.linkey.core.domain.dto.request.ReqUpdateSprintDto;
import com.linkey.core.domain.dto.response.ResSprintDetailDto;
import com.linkey.core.domain.dto.response.ResSprintListDto;

public interface SprintService {
    long createSprint(ReqCreateSprintDto reqCreateSprintDto);
    long updateSprint(ReqUpdateSprintDto reqUpdateSprintDto);
    long deleteSprint(Long sprintId);
    ResSprintDetailDto getSprintById(Long sprintId);
    ResSprintListDto getSprintsByProjectId(Integer projectId);
}
