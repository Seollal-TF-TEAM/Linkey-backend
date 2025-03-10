package com.linkey.core.domain;

import com.linkey.core.domain.enums.MemberRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "team_members")
@IdClass(TeamMemberId.class) // 복합 키 사용
public class TeamMember {

    @Id
    private Integer teamSeqId;

    @Id
    private Integer teamId;

    @Column(nullable = false)
    private String teamName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemberRole memberRole; // ENUM (member, owner)

    @ManyToOne
    @JoinColumn(name = "github_user_id", nullable = false)
    private User user; // FK (users.github_user_id)

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}
