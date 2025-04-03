package com.linkey.core.service.Image;

import com.linkey.core.domain.dto.request.ReqUpdateImageDto;
import com.linkey.core.domain.dto.response.ResImageListDto;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    ResImageListDto getImagesBySprintId(long sprintId);
    ResImageListDto getImagesByProjectId(int projectId);
    long createImage(MultipartFile imageFile);
    long updateImage(ReqUpdateImageDto reqUpdateImageDto);
    long deleteImage(long reqImgId);
}
