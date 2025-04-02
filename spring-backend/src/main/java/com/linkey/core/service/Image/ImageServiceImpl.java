package com.linkey.core.service.Image;

import com.linkey.core.domain.dto.response.ResImageListDto;
import com.linkey.core.service.Image.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public ResImageListDto getImagesBySprintId(long sprintId) {
        return null;
    }

    @Override
    public ResImageListDto getImagesByProjectId(int projectId) {
        return null;
    }
}
