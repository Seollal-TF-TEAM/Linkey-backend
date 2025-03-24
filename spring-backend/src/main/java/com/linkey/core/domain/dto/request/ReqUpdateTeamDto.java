package com.linkey.core.domain.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ReqUpdateTeamDto {
    private String teamName;
    private String teamDesc;
    private List<SingleTeamMember> teamMembers;

    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleTeamMember {
        long githubUserId;
    }
}
/*
예시 :
    ReqUpdateTeamDto.builder()
                .teamName("name")
                .teamDesc("desc")
                .teamMembers(List.of(
                        ReqUpdateTeamDto.SingleTeamMember.builder()
                                .githubUserId(123L)
                                .build()
                    ))
                .build();
 */
