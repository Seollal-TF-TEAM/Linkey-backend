package com.linkey.core.domain.dto.response;

import com.linkey.core.domain.entity.Image;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ResImageListDto {
    private List<SingleImage> images;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleImage {
        long imgId;
        String imageUrl;
        long fileSize;
        String fileType;
    }

    public static ResImageListDto fromEntity(List<Image> imageList) {
        return ResImageListDto.builder()
                .images(
                        imageList.stream()
                                .map(image -> SingleImage.builder()
                                        .imgId(image.getImgId())
                                        .imageUrl(image.getImageUrl())
                                        .fileSize(image.getFileSize())
                                        .fileType(image.getFileType())
                                        .build()
                                ).toList()
                ).build();
    }
}
