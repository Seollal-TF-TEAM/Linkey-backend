package com.linkey.core.controller;

import com.linkey.core.domain.dto.request.ReqUpdateImageDto;
import com.linkey.core.domain.dto.response.ResImageListDto;
import com.linkey.core.domain.dto.response.ResWrapper;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.service.Image.ImageServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Controller
@RequestMapping("/api/images")
public class ImageController {

    private final ImageServiceImpl imageService;

    public ImageController (ImageServiceImpl imageService) { this.imageService = imageService; }


    @GetMapping("imageListByProjectId")
    @ResponseBody
    public ResWrapper getImageListByProjectId(@RequestParam("projectId") int projectId) {
        try {
            ResImageListDto resImageListDto = imageService.getImagesByProjectId(projectId);
            return ResWrapper.resSuccess(resImageListDto);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    @GetMapping("imageListBySprintId")
    @ResponseBody
    public ResWrapper getImageListBySprintId(@RequestParam("sprintId") long sprintId) {
        try {
            ResImageListDto resImageListDto = imageService.getImagesBySprintId(sprintId);
            return ResWrapper.resSuccess(resImageListDto);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    @PostMapping("createImage")
    @ResponseBody
    public ResWrapper createImage(@RequestParam("image") MultipartFile imageFile) {
        try {
            long imgId = imageService.createImage(imageFile);
            return ResWrapper.resSuccess(imgId);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    @PatchMapping("updateImage")
    @ResponseBody
    public ResWrapper updateImage(@RequestBody ReqUpdateImageDto reqUpdateImageDto) {
        try {
            long imgId = imageService.updateImage(reqUpdateImageDto);
            return ResWrapper.resSuccess(imgId);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    @DeleteMapping("deleteImage")
    @ResponseBody
    public ResWrapper deleteImage(@RequestParam("imgId") long reqImgId) {
        try {
            long imgId = imageService.deleteImage(reqImgId);
            return ResWrapper.resSuccess(imgId);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }
}
