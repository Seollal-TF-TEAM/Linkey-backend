package com.linkey.core.controller;


import com.linkey.core.domain.dto.SprintDto;
import com.linkey.core.domain.entity.Sprint;
import com.linkey.core.service.sprint.SprintService;
import com.linkey.core.service.team.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/sprints")
public class SprintController {

    private final SprintService sprintService;

    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    // 프로젝트 id로 해당 프로젝트의 전체 스프린트 가져오기!
    @GetMapping("/{projectId}")
    public List<SprintDto> getAllSprints(@PathVariable Integer id) {
        return sprintService.getAllSprintsByProjectId(id);
    }

    // sprint 정보 insert
    @ResponseBody
    @PostMapping("")
    public Boolean addSprint(@RequestParam SprintDto sprintDto){//@RequestParam String name, @RequestParam int year) {
        return sprintService.addSprint(sprintDto);
    }


}
