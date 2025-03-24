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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
    public Boolean addTeam(TeamDto team) {
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
    public Boolean updateTeam(Integer id, TeamDto teamDto) {
        Team existingTeam = teamRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Team not found with id: " + id));

        existingTeam.updateFromDto(teamDto);

        return true;
    }

    @Override
    public TeamDto getTeamById(Integer id) {
        Team team = teamRepo.findByTeamId(id);
        TeamDto teamDto = TeamDto.fromEntity(team);
        return teamDto;
    }

    @Override
    public List<TeamMemberDto> getTeamMembers(Integer teamId) {
        List<TeamMember> teamMembers = teamMemberRepo.findTeamMembersByTeam_TeamId(teamId);
        return teamMembers.stream().map(TeamMemberDto::fromEntity).toList();
    }

    @Override
    @Transactional
    public Boolean addTeamMember(Integer teamId, TeamMemberDto dto) {
        Team team = teamRepo.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team not found: id=" + teamId));

        TeamMember teamMember = TeamMember.builder()
                .team(team)
                .memberRole(dto.getMemberRole())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        teamMemberRepo.save(teamMember);
        return true;
    }


    @Override
    public Boolean deleteTeamMember(Integer teamMemberId) {
        teamMemberRepo.deleteById(teamMemberId);
        return null;
    }
}
