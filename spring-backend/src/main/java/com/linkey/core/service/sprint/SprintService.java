package com.linkey.core.service.sprint;

import com.linkey.core.domain.dto.SprintDto;
import com.linkey.core.domain.dto.request.ReqCreateSprintDto;
import com.linkey.core.domain.dto.request.ReqUpdateSprintDto;
import com.linkey.core.domain.dto.response.ResSprintDetailDto;
import com.linkey.core.domain.dto.response.ResSprintListDto;

public interface SprintService {
    SprintDto createSprint(ReqCreateSprintDto reqCreateSprintDto);
    SprintDto updateSprint(ReqUpdateSprintDto reqUpdateSprintDto);
    SprintDto deleteSprint(Long sprintId);
    ResSprintDetailDto getSprintById(Long sprintId);
    ResSprintListDto getSprintsByProjectId(Integer projectId);
}
