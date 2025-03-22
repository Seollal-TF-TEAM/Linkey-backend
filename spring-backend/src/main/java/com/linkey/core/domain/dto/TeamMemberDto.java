package com.linkey.core.domain.dto;

import com.linkey.core.domain.entity.TeamMember;
import com.linkey.core.domain.enums.MemberRole;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamMemberDto {
    private Integer memberId;
    private Integer teamId;
    private Long githubUserId;
    private String githubUserName;
    private MemberRole memberRole;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static TeamMemberDto fromEntity(TeamMember teamMember) {
        return TeamMemberDto.builder()
                .memberId(teamMember.getMemberId())
                .teamId(teamMember.getTeam() != null ? teamMember.getTeam().getTeamId() : null)
                .githubUserId(teamMember.getUser() != null ? teamMember.getUser().getGithubUserId() : null)
                .githubUserName(teamMember.getUser() != null ? teamMember.getUser().getGithubUserName() : null)
                .memberRole(teamMember.getMemberRole())
                .createdAt(teamMember.getCreatedAt())
                .updatedAt(teamMember.getUpdatedAt())
                .build();
    }
}
