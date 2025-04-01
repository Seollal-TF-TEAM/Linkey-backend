package com.linkey.core.controller;

import com.linkey.core.domain.dto.SprintDto;
import com.linkey.core.domain.dto.response.ResWrapper;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.service.sprint.SprintService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/sprints/")
public class SprintController {

    private final SprintService sprintService;

    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    // sprint 목록 조회 - project id로 조회
    @ResponseBody
    @GetMapping("sprintsList")
    public ResWrapper getSprints(@RequestParam("projectId") Integer projectId) {
        try {
            List<SprintDto> sprints = sprintService.getSprintsByProjectId(projectId);
            return ResWrapper.resSuccess(sprints);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    // sprint 조회
    @ResponseBody
    @GetMapping("sprintDetail")
    public ResWrapper getSprint(@RequestParam("projectId") Integer projectId, @RequestParam("sprintId") Long sprintId) {
        try {
            SprintDto sprint = sprintService.getSprintById(sprintId);
            return ResWrapper.resSuccess(sprint);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    // sprint 생성
    @ResponseBody
    @PostMapping("createSprint")
    public ResWrapper addSprint(@RequestParam("projectId") Integer projectId, @RequestBody SprintDto sprintDto) {
        try {
            sprintService.addSprint(projectId, sprintDto);
            return ResWrapper.resSuccess("성공");
        } catch (CustomException e) {
            return ResWrapper.resException(e);
        }
    }

    // sprint 수정 (sprint id)
    @ResponseBody
    @PatchMapping("updateSprint")
    public ResWrapper updateSprint(@RequestParam("projectId") Integer projectId, @RequestParam("sprintId") Long sprintId, @RequestBody SprintDto sprintDto) {
        try {
            sprintService.updateSprint(sprintId, sprintDto);
            return ResWrapper.resSuccess("성공");
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }


    // sprint 삭제
    @ResponseBody
    @DeleteMapping("deleteSprint")
    public ResWrapper deleteSprint(@RequestParam("projectId") Integer projectId, @RequestParam("sprintId") Long sprintId) {
        try {
            sprintService.deleteSprint(sprintId);
            return ResWrapper.resSuccess("성공");
        } catch (CustomException e) {
            return ResWrapper.resException(e);
        }
    }

}
