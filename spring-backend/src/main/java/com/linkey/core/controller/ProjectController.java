package com.linkey.core.controller;

import com.linkey.core.domain.dto.request.ReqCreateProjectDto;
import com.linkey.core.domain.dto.request.ReqUpdateProjectDto;
import com.linkey.core.domain.dto.response.ResWrapper;
import com.linkey.core.domain.dto.response.SuccessResult;
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
    public ResWrapper<SuccessResult> getProjectList(@RequestParam("githubUserId") long githubUserId) {
        return ResWrapper.resSuccess(projectService.getProjectsByGithubUserId(githubUserId));
    }

    // 테스트 완료
    // http://localhost:8080/api/projects/projectDetail?projectId=12
    @GetMapping("projectDetail")
    @ResponseBody
    public ResWrapper<SuccessResult> getProjectDetail(@RequestParam("projectId") int projectId) {
        return ResWrapper.resSuccess(projectService.getProjectByProjectId(projectId));
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
    public ResWrapper<SuccessResult> createProject(@RequestBody ReqCreateProjectDto reqCreateProjectDto) {
        return ResWrapper.resSuccess(projectService.createProject(reqCreateProjectDto));
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
    public ResWrapper<SuccessResult> updateProject(@RequestBody ReqUpdateProjectDto reqUpdateProjectDto) {
        return ResWrapper.resSuccess(projectService.updateProject(reqUpdateProjectDto));
    }

    // 테스트 완료
    // http://localhost:8080/api/projects/deleteProject?projectId=1
    @DeleteMapping("deleteProject")
    @ResponseBody
    public ResWrapper<SuccessResult> deleteProject(@RequestParam("projectId") int reqProjectId) {
        return ResWrapper.resSuccess(projectService.deleteProject(reqProjectId));
    }
}
