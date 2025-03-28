package com.linkey.core.controller;

import com.linkey.core.domain.dto.SprintDto;
import com.linkey.core.service.sprint.SprintService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/projects/{projectId}/sprints")
public class SprintController {

    private final SprintService sprintService;

    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    // sprint 목록 조회 - project id로 조회
    @ResponseBody
    @GetMapping
    public ResponseEntity<List<SprintDto>> getSprints(@PathVariable Integer projectId) {
        List<SprintDto> sprints = sprintService.getSprintsByProjectId(projectId);
        return ResponseEntity.ok(sprints);
    }

    // sprint 생성
    @PostMapping
    public ResponseEntity<?> addSprint(@PathVariable Integer projectId, @RequestBody SprintDto sprintDto) {
        sprintService.addSprint(projectId, sprintDto);
        return ResponseEntity.ok("스프린트 등록 완료!");
    }

    // sprint 수정 (sprint id)
    @ResponseBody
    @PatchMapping("/{sprintId}")
    public Boolean updateSprint(@PathVariable Integer projectId, @PathVariable Long sprintId, @RequestBody SprintDto sprintDto) {
        return sprintService.updateSprint(sprintId, sprintDto);
    }


    // sprint 삭제
    @ResponseBody
    @DeleteMapping("/{sprintId}")
    public Boolean deleteSprint(@PathVariable Integer projectId, @PathVariable Long sprintId) {
        return sprintService.deleteSprint(sprintId);
    }

    // sprint 조회
    @ResponseBody
    @GetMapping("/{sprintId}")
    public ResponseEntity<SprintDto> getSprint(@PathVariable Long projectId, @PathVariable Long sprintId) {
        SprintDto sprint = sprintService.getSprintById(sprintId);
        return ResponseEntity.ok(sprint);
    }
}
