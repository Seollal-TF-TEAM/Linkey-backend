package com.linkey.core.repository.team;

import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    Team save(Team team);
    TeamDto findByTeamId(Integer name);
    void deleteByTeamId(Integer id);
}
