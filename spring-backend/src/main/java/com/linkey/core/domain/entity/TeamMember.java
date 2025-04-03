package com.linkey.core.domain.entity;

import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.enums.MemberRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "team_members")
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_members_seq")
    @SequenceGenerator(name = "team_members_seq", sequenceName = "team_members_seq_id", allocationSize = 1)
    private Integer memberId;

    @ManyToOne
    @JoinColumn(name = "teamId", nullable = false)
    private Team team;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private MemberRole memberRole;

    @ManyToOne
    @JoinColumn(name = "githubUserId", nullable = false)
    private GitUser user;

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    public static TeamMember toEntity(TeamMemberDto dto) {
        return TeamMember.builder()
                .memberId(dto.getMemberId())
                .team(dto.getTeamId() != null ? new Team(dto.getTeamId()) : null)
                .user(dto.getGithubUserId() != null ? new GitUser(dto.getGithubUserId()) : null)
                .memberRole(dto.getMemberRole())
                .createdAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : LocalDateTime.now())
                .updatedAt(dto.getUpdatedAt() != null ? dto.getUpdatedAt() : LocalDateTime.now())
                .build();
    }

}
