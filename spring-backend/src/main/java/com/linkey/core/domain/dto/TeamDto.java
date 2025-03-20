package com.linkey.core.domain.dto;

import com.linkey.core.domain.entity.Team;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private Integer teamId;
    private String teamName;
    private String teamDesc;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static TeamDto fromEntity(Team team) {
        return TeamDto.builder()
                .teamId(team.getTeamId())
                .teamName(team.getTeamName())
                .teamDesc(team.getTeamDesc())
                .createdAt(team.getCreatedAt())
                .updatedAt(team.getUpdatedAt())
                .build();
    }
}
