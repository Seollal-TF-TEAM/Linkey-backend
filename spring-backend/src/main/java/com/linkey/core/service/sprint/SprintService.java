package com.linkey.core.service.sprint;

import com.linkey.core.domain.dto.SprintDto;
import java.util.List;

public interface SprintService {

    Boolean addSprint(Integer projectId, SprintDto sprintDto);

    Boolean updateSprint(Long sprintId, SprintDto sprintDto);

//    List<SprintDto> findByProjectId(Integer projectId); // 프로젝트별 스프린트 조회 (필요한 경우)
}
