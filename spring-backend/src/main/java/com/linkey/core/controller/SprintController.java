package com.linkey.core.controller;

import com.linkey.core.domain.dto.SprintDto;
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
    public ResponseEntity<List<SprintDto>> getSprints(@RequestParam("projectId") Integer projectId) {
        List<SprintDto> sprints = sprintService.getSprintsByProjectId(projectId);
        return ResponseEntity.ok(sprints);
    }

    // sprint 조회
    @ResponseBody
    @GetMapping("sprintDetail")
    public ResponseEntity<SprintDto> getSprint(@RequestParam("projectId") Integer projectId, @RequestParam("sprintId") Long sprintId) {
        SprintDto sprint = sprintService.getSprintById(sprintId);
        return ResponseEntity.ok(sprint);
    }

    // sprint 생성
    @PostMapping("createSprint")
    public ResponseEntity<?> addSprint(@RequestParam("projectId") Integer projectId, @RequestBody SprintDto sprintDto) {
        sprintService.addSprint(projectId, sprintDto);
        return ResponseEntity.ok("스프린트 등록 완료!");
    }

    // sprint 수정 (sprint id)
    @ResponseBody
    @PatchMapping("updateSprint")
    public Boolean updateSprint(@RequestParam("projectId") Integer projectId, @RequestParam("sprintId") Long sprintId, @RequestBody SprintDto sprintDto) {
        return sprintService.updateSprint(sprintId, sprintDto);
    }


    // sprint 삭제
    @ResponseBody
    @DeleteMapping("deleteSprint")
    public Boolean deleteSprint(@RequestParam("projectId") Integer projectId, @RequestParam("sprintId") Long sprintId) {
        return sprintService.deleteSprint(sprintId);
    }

}
