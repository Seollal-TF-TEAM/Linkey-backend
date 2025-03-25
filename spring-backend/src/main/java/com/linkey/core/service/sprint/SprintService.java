package com.linkey.core.service.sprint;

import com.linkey.core.domain.dto.SprintDto;

import java.util.List;

public interface SprintService {

    public List<SprintDto> findByProjectId(Integer projectId);

    public Boolean addSprint(SprintDto sprintDto);

//    List<SprintDto> findByProjectId(Long projectId);

    /*
        - Sprint insert 해야할 것
            - project id - fk
            - sprint name
            - sprint contents
            - sprint start at
            - sprint end at

        1. 프로젝트 id를 프로젝트 리포지토리에서 찾음
        2. new sprint를 만듦
        3. sprint repository에 save를 함

        * */
    Boolean addSprint(Integer projectId, SprintDto sprintDto);
}
