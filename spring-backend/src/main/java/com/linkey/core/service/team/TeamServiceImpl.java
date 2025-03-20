package com.linkey.core.service.team;

import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.domain.entity.TeamMember;
import com.linkey.core.repository.team.TeamMemberRepository;
import com.linkey.core.repository.team.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepo;

    private final TeamMemberRepository teamMemberRepo;

    public TeamServiceImpl(TeamRepository teamRepo, TeamMemberRepository teamMemberRepo) {
        this.teamRepo = teamRepo;
        this.teamMemberRepo = teamMemberRepo;
    }


    @Override
    public Boolean addTeam(Team team) {
        Boolean teamSaveResult = teamRepo.save(team);

        return teamSaveResult;
    }

    @Override
    public Boolean deleteTeam(Integer id) {
        Optional<TeamDto> teamDtoOptional = Optional.ofNullable(teamRepo.findByTeamId(id));

        TeamDto teamDto = teamDtoOptional.orElseThrow(() ->
                new EntityNotFoundException("Team not found with id: " + id)
        );

        teamRepo.deleteById(id);
        return true;
    }

    @Override
    public Boolean updateTeam(Team team) {
        return null;
    }

    @Override
    public TeamDto getTeamById(Integer id) {
        TeamDto team = teamRepo.findByTeamId(id);

        return team;
    }

    @Override
    public List<TeamMemberDto> getTeamMembers(Integer teamId) {
        List<TeamMemberDto> teamMembers = teamMemberRepo.findByTeamId(teamId);

        return teamMembers;
    }

    @Override
    public Boolean addTeamMember(TeamMember teamMember) {
        return null;
    }

    @Override
    public Boolean deleteTeamMember(Integer teamMemberId) {
        return null;
    }
}
