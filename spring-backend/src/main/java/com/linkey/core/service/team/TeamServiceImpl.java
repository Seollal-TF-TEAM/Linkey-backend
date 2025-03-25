package com.linkey.core.service.team;

import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.dto.request.ReqCreateTeamDto;
import com.linkey.core.domain.dto.response.ResTeamListDto;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.domain.entity.TeamMember;
import com.linkey.core.repository.team.TeamMemberRepository;
import com.linkey.core.repository.team.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public Boolean addTeam(ReqCreateTeamDto team) {
        Team teamEntity = Team.toEntity(team);
        Team saveTeam = Optional.of(teamRepo.save(teamEntity))
                .orElseThrow(() -> new IllegalArgumentException("save Fail"));

        return true;
    }

    @Override
    public Boolean deleteTeam(Integer id) {
        Optional<Team> teamOptional = Optional.ofNullable(teamRepo.findByTeamId(id));

        Team team = teamOptional.orElseThrow(() ->
                new EntityNotFoundException("Team not found with id: " + id)
        );

        teamRepo.deleteById(id);
        return true;
    }

    @Override
    @Transactional
    public Boolean updateTeam(TeamDto team) {
        Team teamEntity = teamRepo.findByTeamId(team.getTeamId());
        if (teamEntity== null) throw new EntityNotFoundException("Team not found");

        if (team.getTeamDesc() != null) teamEntity.setTeamDesc(team.getTeamDesc());
        if (team.getTeamName() != null) teamEntity.setTeamName(team.getTeamName());

        teamEntity.setUpdatedAt(LocalDateTime.now());

        return true;
    }

    @Override
    public ResTeamListDto getTeamById(Integer id) {
        Team team = teamRepo.findByTeamId(id);
        ResTeamListDto teamDto = ResTeamListDto.fromEntity(team);
        return teamDto;
    }

    @Override
    public List<TeamMemberDto> getTeamMembers(Integer teamId) {
        List<TeamMember> teamMembers = teamMemberRepo.findTeamMembersByTeam_TeamId(teamId);
        return teamMembers.stream().map(TeamMemberDto::fromEntity).toList();
    }

    @Override
    public Boolean addTeamMember(TeamMemberDto teamMember) {
        TeamMember teamMemberEntity = TeamMember.toEntity(teamMember);
        TeamMember saveTeamMember = Optional.ofNullable(teamMemberRepo.save(teamMemberEntity))
                .orElseThrow(() -> new EntityNotFoundException("can not add member to team member"));


        return true;
    }

    @Override
    public Boolean deleteTeamMember(Integer teamMemberId) {
        teamMemberRepo.deleteById(teamMemberId);
        return null;
    }
}
