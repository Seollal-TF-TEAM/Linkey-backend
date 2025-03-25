package com.linkey.core.controller;

import com.linkey.core.domain.dto.SprintDto;
import com.linkey.core.service.sprint.SprintService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/sprints")
public class SprintController {

    private final SprintService sprintService;

    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    @PostMapping
    public ResponseEntity<?> addSprint(@PathVariable Integer projectId, @RequestBody SprintDto sprintDto) {
        sprintService.addSprint(projectId, sprintDto);
        return ResponseEntity.ok("스프린트 등록 완료!");
    }

//    @GetMapping
//    public ResponseEntity<List<SprintDto>> getSprints(@PathVariable Integer projectId) {
//        List<SprintDto> sprints = sprintService.findByProjectId(projectId);
//        return ResponseEntity.ok(sprints);
//    }
}
