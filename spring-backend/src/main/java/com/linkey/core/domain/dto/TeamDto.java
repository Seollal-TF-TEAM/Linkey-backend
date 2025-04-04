package com.linkey.core.domain.dto;

import com.linkey.core.domain.entity.Team;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private Integer teamId;

    @NotBlank(message = "팀 이름은 필수 입력 값입니다.")
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
