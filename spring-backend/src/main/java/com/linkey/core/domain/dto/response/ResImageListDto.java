package com.linkey.core.domain.dto.response;

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
        int imgId;
        String imageUrl;
        long fileSize;
        String fileType;
    }
}
