package com.linkey.core.service.Image;

import com.linkey.core.domain.dto.response.ResImageListDto;
import org.springframework.stereotype.Service;


public interface ImageService {

    public ResImageListDto getImagesBySprintId(long sprintId);
    public ResImageListDto getImagesByProjectId(int projectId);
}
