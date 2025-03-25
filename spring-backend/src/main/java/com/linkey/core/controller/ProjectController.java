package com.linkey.core.controller;

import com.linkey.core.domain.dto.request.ReqCreateProjectDto;
import com.linkey.core.domain.dto.request.ReqUpdateProjectDto;
import com.linkey.core.domain.dto.response.ErrorResult;
import com.linkey.core.domain.dto.response.ResWrapper;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.exception.CustomException;
import com.linkey.core.service.project.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController (ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping("projectList")
    public List<Project> getPageProjectList() {
        return null;
    }

    @GetMapping("projectDetail")
    public Project getPageProjectDetail() {
        return null;
    }

    @PostMapping("createProject")
    public ResWrapper createProject(@RequestBody ReqCreateProjectDto reqCreateProjectDto) {
        try {
            Integer projectId = projectService.createProject(reqCreateProjectDto);
            return ResWrapper.resSuccess(projectId);
        } catch (CustomException e){
            return ResWrapper.resCustomException(e);
        } catch (Exception e) {
            return ResWrapper.resException(e);
        }
    }

    @PatchMapping("updateProject")
    public ResWrapper updateProject(@RequestBody ReqUpdateProjectDto reqUpdateProjectDto) {
        try {
            Integer projectId = projectService.updateProject(reqUpdateProjectDto);
            return ResWrapper.resSuccess(projectId);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        } catch (Exception e) {
            return ResWrapper.resException(e);
        }

    }

    @PatchMapping("deleteProject")
    public  deleteProject() {
        return null;
    }
}
