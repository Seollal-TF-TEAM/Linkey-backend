package com.linkey.core.controller;

import com.linkey.core.domain.entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/projects")
public class ProjectController {

    @GetMapping("getPageProjectList")
    public List<Project> getPageProjectList() {
        return null;
    }

    @PostMapping("create")
    public Boolean createProject() {
        return null;
    }

    @GetMapping("getPageProjectDetail")
    public Project getPageProjectDetail() {
        return null;
    }

    @PatchMapping("udpate")
    public Boolean udpateProject() {
        return null;
    }
}
