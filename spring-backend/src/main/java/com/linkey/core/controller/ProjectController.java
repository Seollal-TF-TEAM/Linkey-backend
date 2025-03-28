package com.linkey.core.controller;

import com.linkey.core.domain.dto.request.ReqCreateProjectDto;
import com.linkey.core.domain.dto.request.ReqUpdateProjectDto;
import com.linkey.core.domain.dto.response.ResProjectDetailDto;
import com.linkey.core.domain.dto.response.ResProjectListDto;
import com.linkey.core.domain.dto.response.ResWrapper;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.service.project.ProjectService;
import com.linkey.core.service.project.ProjectServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectServiceImpl projectService;

    public ProjectController (ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }


    @GetMapping("projectList")
    @ResponseBody
    public ResWrapper getProjectList(@RequestParam("githubUserId") long githubUserId) {
        try {
            ResProjectListDto resProjectListDto = projectService.getProjectsByGithubUserId(githubUserId);
            return ResWrapper.resSuccess(resProjectListDto);
        } catch (CustomException e){
            return ResWrapper.resCustomException(e);
        }
    }

    @GetMapping("projectDetail")
    @ResponseBody
    public ResWrapper getProjectDetail(@RequestParam("projectId") int projectId) {
        try {
            ResProjectDetailDto resProjectDetailDto = projectService.getProjectByProjectId(projectId);
            return ResWrapper.resSuccess(resProjectDetailDto);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    @PostMapping("createProject")
    @ResponseBody
    public ResWrapper createProject(@RequestBody ReqCreateProjectDto reqCreateProjectDto) {
        try {
            Integer projectId = projectService.createProject(reqCreateProjectDto);
            return ResWrapper.resSuccess(projectId);
        } catch (CustomException e){
            return ResWrapper.resCustomException(e);
        }
    }

    @PatchMapping("updateProject")
    @ResponseBody
    public ResWrapper updateProject(@RequestBody ReqUpdateProjectDto reqUpdateProjectDto) {
        try {
            Integer projectId = projectService.updateProject(reqUpdateProjectDto);
            return ResWrapper.resSuccess(projectId);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    @PatchMapping("deleteProject")
    @ResponseBody
    public ResWrapper deleteProject(@RequestBody int reqProjectId) {
        try {
            Integer projectId = projectService.deleteProject(reqProjectId);
            return ResWrapper.resSuccess(projectId);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }
}
