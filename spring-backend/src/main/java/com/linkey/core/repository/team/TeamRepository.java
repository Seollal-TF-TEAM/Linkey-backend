package com.linkey.core.repository.team;

import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.dto.response.ResTeamListDto;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.domain.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Query("SELECT t FROM Team t ORDER BY t.createdAt DESC")
    List<Team> findAllOrderByTeamIdDesc();
    List<Team> findTeamsByTeamMembers(List<TeamMember> teamMembers);
    List<Team> findTeamsByTeamId(Integer teamId);
    Optional<Team> findByTeamId(Integer id);
    void deleteByTeamId(Integer id);
}
