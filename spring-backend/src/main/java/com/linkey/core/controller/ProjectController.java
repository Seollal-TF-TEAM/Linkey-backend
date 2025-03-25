package com.linkey.core.controller;

import com.linkey.core.domain.dto.request.ReqUpdateProjectDto;
import com.linkey.core.domain.dto.response.ErrorResult;
import com.linkey.core.domain.dto.response.ResWrapper;
import com.linkey.core.domain.dto.response.SuccessResult;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.exception.CustomException;
import com.linkey.core.exception.ErrorCode;
import com.linkey.core.service.project.ProjectService;
import com.linkey.core.service.project.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public Boolean createProject() {
        return null;
    }

    @PatchMapping("updateProject")
    public ResWrapper updateProject(@RequestBody ReqUpdateProjectDto reqUpdateProjectDto) {
        ResWrapper result = null;
        try {
            Integer projectId = projectService.updateProject(reqUpdateProjectDto);
            result = ResWrapper.builder()
                    .result(
                            SuccessResult.builder()
                                    .status("Success")
                                    .data(projectId)
                                    .build()
                    ).build();
            return result;
        } catch (CustomException e) {
            result = ResWrapper.builder()
                    .result(
                            ErrorResult.builder()
                                    .status(e.getErrorCode().getHttpStatus().value())
                                    .errorCode(e.getErrorCode().getCode())
                                    .message(e.getErrorCode().getMessage())
                    ).build();
            return result;
        } catch (Exception e) {
            result = ResWrapper.builder()
                    .result(
                            ErrorResult.builder()
                                    .status(400)
                                    .errorCode(9999)
                                    .message(e.getMessage())
                                    .build()
                    ).build();
            return result;
        }

    }

    @PatchMapping("deleteProject")
    public Boolean deleteProject() {
        return null;
    }
}
