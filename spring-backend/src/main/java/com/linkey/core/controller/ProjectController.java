package com.linkey.core.controller;

import com.linkey.core.domain.dto.request.ReqCreateProjectDto;
import com.linkey.core.domain.dto.request.ReqUpdateProjectDto;
import com.linkey.core.domain.dto.response.ResProjectDetailDto;
import com.linkey.core.domain.dto.response.ResProjectListDto;
import com.linkey.core.domain.dto.response.ResWrapper;
import com.linkey.core.global.exception.CustomException;
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

    // 테스트 완료
    // http://localhost:8080/api/projects/projectList?githubUserId=103468518
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

    // 테스트 완료
    // http://localhost:8080/api/projects/projectDetail?projectId=12
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

    // 테스트 완료
    // http://localhost:8080/api/projects/createProject
    /* body
    {
        "projectName" : "projectName-250404-test",
        "projectDesc" : "projectDesc-250404-test",
        "githubRepoUrl" : "https://localhost",
        "team" : {
            "teamId" : 19
        }
    }
     */
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

    // 테스트 완료
    // http://localhost:8080/api/projects/updateProject
    /* body
    {
        "projectId": 1,
        "projectName": "projectName-update-1",
        "projectDesc": "projectDesc-update-1",
        "githubRepoUrl": "http://updateurl-1"
    }
     */
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

    // 테스트 완료
    // http://localhost:8080/api/projects/deleteProject?projectId=1
    @DeleteMapping("deleteProject")
    @ResponseBody
    public ResWrapper deleteProject(@RequestParam("projectId") int reqProjectId) {
        try {
            Integer projectId = projectService.deleteProject(reqProjectId);
            return ResWrapper.resSuccess(projectId);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }
}
