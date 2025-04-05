package com.linkey.core.repository.team;

import com.linkey.core.domain.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    //Team save(Team team);
    Optional<Team> findByTeamId(Integer id);
    void deleteByTeamId(Integer id);
}
