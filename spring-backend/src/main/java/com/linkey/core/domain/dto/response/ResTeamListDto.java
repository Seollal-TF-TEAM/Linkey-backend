package com.linkey.core.domain.dto.response;

import com.linkey.core.domain.entity.Team;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ResTeamListDto {
    private List<SingleTeam> teams;

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleTeam {
        int teamId;
        String teamName;
        String teamDesc;
        LocalDateTime createAt;
        LocalDateTime updatedAt;
        List<SingleTeamMember> teamMembers;
    }

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleTeamMember {
        int memberId;
    }

    public static ResTeamListDto fromEntity(List<Team> teamEntityList) {

        return ResTeamListDto.builder()
                .teams(
                        teamEntityList.stream()
                                .map((teamEntity) -> SingleTeam.builder()
                                        .teamId(teamEntity.getTeamId())
                                        .teamName(teamEntity.getTeamName())
                                        .teamDesc(teamEntity.getTeamDesc())
                                        .createAt(teamEntity.getCreatedAt())
                                        .updatedAt(teamEntity.getUpdatedAt())
                                        .teamMembers(
                                                teamEntity.getTeamMembers().stream()
                                                        .map((teamMemberEntity) -> SingleTeamMember.builder()
                                                                .memberId(teamMemberEntity.getMemberId())
                                                                .build()
                                                        ).toList()
                                        )
                                        .build()
                                ).toList()
                ).build();
    }
}

/*
예시 :
    ResTeamListDto.builder()
            .teams(List.of(
                    ResTeamListDto.SingleTeam.builder()
                            .teamId(1)
                            .teamName("name")
                            .teamDesc("desc")
                            .createAt(LocalDateTime.now())
                            .teamMembers(List.of(
                                    ResTeamListDto.SingleTeamMember.builder()
                                            .memberId(123)
                                            .build()
                            ))
                            .build()
            ));
 */