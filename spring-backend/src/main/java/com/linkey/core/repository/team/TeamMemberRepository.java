package com.linkey.core.repository.team;

import com.linkey.core.domain.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer> {
    List<TeamMember> findTeamMembersByTeam_TeamId(Integer teamId);
    TeamMember save(TeamMember teamMember);
    void deleteByTeam_TeamId(Integer teamId);

    boolean existsByTeam_TeamIdAndUser_GithubUserId(Integer teamId, Long githubUserId);

}
