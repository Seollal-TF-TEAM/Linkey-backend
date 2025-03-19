package com.linkey.core.domain.dto;

import com.linkey.core.domain.entity.Image;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {
    private Long imgId;
    private String imageUrl;
    private String imagePath;
    private Long fileSize;
    private String fileType;
    private LocalDateTime createdAt;
    private Long projectId;
    private Long sprintId;

    public static ImageDto fromEntity(Image image) {
        return ImageDto.builder()
                .imgId(image.getImgId())
                .imageUrl(image.getImageUrl())
                .imagePath(image.getImagePath())
                .fileSize(image.getFileSize())
                .fileType(image.getFileType())
                .createdAt(image.getCreatedAt())
                .projectId(image.getProject() != null ? Long.valueOf(image.getProject().getProjectId()) : null)
                .sprintId(image.getSprint() != null ? image.getSprint().getSprintId() : null)
                .build();
    }
}
