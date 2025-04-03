package com.linkey.core.domain.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class ReqCreateImageDto {
    private int imgId;
    private String imageUrl;
    private long fileSize;
    private String fileType;
}
