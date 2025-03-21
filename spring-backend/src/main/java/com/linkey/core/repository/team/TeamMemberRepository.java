package com.linkey.core.repository.team;

import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer> {
    List<TeamMember> findByTeamId(Integer teamId);
    TeamMember save(TeamMember teamMember);
    void deleteByTeamId(Integer teamId);
}
