package com.linkey.core.repository.image.custom;

import com.linkey.core.domain.entity.Image;

import java.util.List;

public interface ImageRepositoryCustom {
    public List<Image> findImagesByProjectId(int projectId);
    public List<Image> findImagesBySprintId(long sprintId);
}
