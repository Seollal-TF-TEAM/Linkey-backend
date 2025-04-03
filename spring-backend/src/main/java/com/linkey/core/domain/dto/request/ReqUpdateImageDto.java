package com.linkey.core.domain.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class ReqUpdateImageDto {
    private long imgId;
    private SingleProject project;
    private SingleSprint sprint;

    @Getter
    @Builder
    @AllArgsConstructor
    @ToString
    public static class SingleProject {
        int projectId;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @ToString
    public static class SingleSprint {
        long sprintId;
    }
}
