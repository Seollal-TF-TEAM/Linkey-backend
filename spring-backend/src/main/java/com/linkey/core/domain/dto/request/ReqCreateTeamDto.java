package com.linkey.core.domain.dto.request;

import com.linkey.core.domain.enums.MemberRole;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ReqCreateTeamDto {
    private String teamName;
    private String teamDesc;
    private List<SingleTeamMember> teamMembers;

    @Builder
    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    public static class SingleTeamMember {
        Long githubUserId;
        MemberRole role;
    }
}
/*
예시 :
    ReqCreateTeamDto.builder()
                .teamName("name")
                .teamDesc("desc")
                .teamMembers(List.of(
                        ReqCreateTeamDto.SingleTeamMember.builder()
                                .githubUserId(123L)
                                .build()
                    ))
                .build();
 */
