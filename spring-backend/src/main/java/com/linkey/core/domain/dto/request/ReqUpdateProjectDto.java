package com.linkey.core.domain.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor

public class ReqUpdateProjectDto {
    private int projectId;
    private String projectName;
    private String projectDesc;
    private String githubRepoUrl;
}