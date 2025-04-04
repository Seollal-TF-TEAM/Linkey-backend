package com.linkey.core.controller;

import com.linkey.core.domain.dto.request.ReqCreateSprintDto;
import com.linkey.core.domain.dto.request.ReqUpdateSprintDto;
import com.linkey.core.domain.dto.response.ResSprintDetailDto;
import com.linkey.core.domain.dto.response.ResSprintListDto;
import com.linkey.core.domain.dto.response.ResWrapper;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.service.sprint.SprintService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/sprints/")
public class SprintController {

    private final SprintService sprintService;

    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    // 테스트 완료
    // http://localhost:8080/api/sprints/sprintsList?projectId=17
    // sprint 목록 조회 - project id로 조회
    @ResponseBody
    @GetMapping("sprintList")
    public ResWrapper getSprintList(@RequestParam("projectId") Integer projectId) {
        try {
            ResSprintListDto sprints = sprintService.getSprintsByProjectId(projectId);
            return ResWrapper.resSuccess(sprints);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    // 테스트 완료
    // http://localhost:8080/api/sprints/sprintDetail?sprintId=34
    // sprint 조회
    @ResponseBody
    @GetMapping("sprintDetail")
    public ResWrapper getSprintDetail(@RequestParam("sprintId") Long sprintId) {
        try {
            ResSprintDetailDto sprint = sprintService.getSprintById(sprintId);
            return ResWrapper.resSuccess(sprint);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    // 테스트 완료
    // http://localhost:8080/api/sprints/createSprint
    /* body
    {
        "sprintName": "1차 개발 스프린트-3",
        "sprintContent": "기본 기능 구현 및 테스트",
        "sprintStartAt": "2025-04-25",
        "sprintEndAt": "2025-04-05",
        "project": {
            "projectId": 12
        }
    }
     */
    // sprint 생성
    @ResponseBody
    @PostMapping("createSprint")
    public ResWrapper createSprint(@RequestBody ReqCreateSprintDto reqCreateSprintDto) {
        try {
            long sprintId = sprintService.createSprint(reqCreateSprintDto);
            return ResWrapper.resSuccess(sprintId);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    // 테스트 완료
    // http://localhost:8080/api/sprints/updateSprint
    /* body
    {
        "sprintId": 43,
        "sprintName": "sprint #2",
        "sprintContents": "hi there",
        "sprintStartAt": "2025-03-22",
        "sprintEndAt": "2025-03-23"
    }
     */
    // sprint 수정 (sprint id)
    @ResponseBody
    @PatchMapping("updateSprint")
    public ResWrapper updateSprint(@RequestBody ReqUpdateSprintDto reqUpdateSprintDto) {
        try {
            long sprintId = sprintService.updateSprint(reqUpdateSprintDto);
            return ResWrapper.resSuccess(sprintId);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    // 테스트 완료
    // http://localhost:8080/api/sprints/deleteSprint?sprintId=50
    // sprint 삭제
    @ResponseBody
    @DeleteMapping("deleteSprint")
    public ResWrapper deleteSprint(@RequestParam("sprintId") Long reqSprintId) {
        try {
            long sprintId = sprintService.deleteSprint(reqSprintId);
            return ResWrapper.resSuccess(sprintId);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

}
