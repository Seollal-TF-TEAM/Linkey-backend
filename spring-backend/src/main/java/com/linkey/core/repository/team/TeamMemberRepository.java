package com.linkey.core.repository.team;

import com.linkey.core.domain.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer> {
    Optional<TeamMember> findByMemberId(Integer memberId);

    List<TeamMember> findByTeam_TeamIdOrderByCreatedAtDesc(Integer teamId);
    //TeamMember save(TeamMember teamMember);
    //void deleteByTeam_TeamId(Integer teamId);
    List<TeamMember> findByUser_GithubUserId(Long githubUserId);

    boolean existsByTeam_TeamIdAndUser_GithubUserId(Integer teamId, Long githubUserId);
}
