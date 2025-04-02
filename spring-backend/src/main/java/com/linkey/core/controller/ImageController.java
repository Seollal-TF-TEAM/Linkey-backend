package com.linkey.core.controller;

import com.linkey.core.domain.dto.response.ResImageListDto;
import com.linkey.core.domain.dto.response.ResWrapper;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.service.Image.ImageServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/api/images")
public class ImageController {

    private final ImageServiceImpl imageService;

    public ImageController (ImageServiceImpl imageService) { this.imageService = imageService; }


    @GetMapping("imageList")
    @ResponseBody
    public ResWrapper getImageListByProjectId(@RequestParam("projectId") int projectId) {
        try {
            ResImageListDto resImageListDto = imageService.getImagesByProjectId(projectId);
            return ResWrapper.resSuccess(resImageListDto);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    @GetMapping("imageList")
    @ResponseBody
    public ResWrapper getImageListBySprintId(@RequestParam("sprintId") long sprintId) {
        try {
            ResImageListDto resImageListDto = imageService.getImagesBySprintId(sprintId);
            return ResWrapper.resSuccess(resImageListDto);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

}
