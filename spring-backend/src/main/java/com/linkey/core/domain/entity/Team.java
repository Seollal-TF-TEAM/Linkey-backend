package com.linkey.core.domain.entity;

import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.dto.request.ReqCreateTeamDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    public Team(Integer teamId) {
        this.teamId = teamId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq")
    @SequenceGenerator(name = "team_seq", sequenceName = "team_seq_id", allocationSize = 1)
    private Integer teamId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String teamName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String teamDesc;

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamMember> teamMembers = new ArrayList<>();

    public static Team toEntity(TeamDto dto) {
        return Team.builder()
                .teamId(dto.getTeamId())
                .teamName(dto.getTeamName())
                .teamDesc(dto.getTeamDesc())
                .createdAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : LocalDateTime.now())
                .updatedAt(dto.getUpdatedAt() != null ? dto.getUpdatedAt() : LocalDateTime.now())
                .build();
    }
    public void updateFromDto(TeamDto dto) {
        if (dto.getTeamName() != null) {
            this.teamName = dto.getTeamName();
        }

        if (dto.getTeamDesc() != null) {
            this.teamDesc = dto.getTeamDesc();
        }

        this.updatedAt = LocalDateTime.now(); // 수정 시점 갱신
    }

    public static Team fromDto(ReqCreateTeamDto dto, Function<Long, GitUser> userResolver) {
        Team team = Team.builder()
                .teamName(dto.getTeamName())
                .teamDesc(dto.getTeamDesc())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        List<TeamMember> members = dto.getTeamMembers().stream()
                .map(memberDto -> {
                    GitUser user = userResolver.apply(memberDto.getGithubUserId());
                    return TeamMember.fromDto(memberDto, user, team);
                })
                .toList();

        team.setTeamMembers(members);
        return team;
    }


}
