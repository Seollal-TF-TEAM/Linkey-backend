package com.linkey.core.service.team;

import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.dto.request.ReqCreateTeamDto;
import com.linkey.core.domain.dto.response.ResTeamListDto;
import com.linkey.core.domain.entity.GitUser;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.domain.entity.TeamMember;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.global.exception.ErrorCode;
import com.linkey.core.global.resolver.UserResolver;
import com.linkey.core.repository.team.TeamMemberRepository;
import com.linkey.core.repository.team.TeamRepository;
import com.linkey.core.repository.user.GitUserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Slf4j
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepo;
    private final TeamMemberRepository teamMemberRepo;
    private final GitUserRepository gitUserRepository;
    private final UserResolver userResolver;

    public TeamServiceImpl(TeamRepository teamRepo, TeamMemberRepository teamMemberRepo, GitUserRepository gitUserRepository, UserResolver userResolver) {
        this.teamRepo = teamRepo;
        this.teamMemberRepo = teamMemberRepo;
        this.gitUserRepository = gitUserRepository;
        this.userResolver = userResolver;
    }

    @Transactional
    @Override
    public TeamDto addTeam(TeamDto team) {
        Team teamEntity = Team.toEntity(team);
        Team saveTeam = Optional.of(teamRepo.save(teamEntity))
                .orElseThrow(() -> new CustomException(ErrorCode.INVALID_INPUT_VALUE));
        return TeamDto.fromEntity(saveTeam);
    }

    @Override
    public Boolean deleteTeam(Integer id) {
        Team team = teamRepo.findByTeamId(id)
                    .orElseThrow(() -> new CustomException(ErrorCode.TEAM_NOT_FOUND));
        teamRepo.deleteByTeamId(id);
        return true;
    }

    @Override
    @Transactional
    public TeamDto updateTeam(Integer id, TeamDto teamDto) {
        Team existingTeam = teamRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Team not found with id: " + id));
        existingTeam.updateFromDto(teamDto);
        return teamDto;
    }

    @Override
    public TeamDto getTeamById(Integer id) {
        Team team = teamRepo.findByTeamId(id).orElseThrow(() -> new CustomException(ErrorCode.TEAM_NOT_FOUND));
        return TeamDto.fromEntity(team);
    }

    @Override
    public List<TeamMemberDto> getTeamMembers() {
        List<TeamMember> teamMembers = teamMemberRepo.findAll();
        return teamMembers.stream().map(TeamMemberDto::fromEntity).toList();
    }

    @Override
    public List<TeamMemberDto> getTeamMembersByTeamId(Integer teamId) {
        List<TeamMember> teamMembers = teamMemberRepo.findByTeam_TeamId(teamId);
        return teamMembers.stream().map(TeamMemberDto::fromEntity).toList();
    }

    @Override
    public List<TeamMemberDto> getTeamMembersByUser(Long githubUserId) {
        List<TeamMember> teamMembers = teamMemberRepo.findByUser_GithubUserId(githubUserId);
        return teamMembers.stream().map(TeamMemberDto::fromEntity).toList();
    }


    @Transactional
    @Override
    public Boolean addTeamMember(Integer teamId, TeamMemberDto dto) {
        Team team = teamRepo.findById(teamId)
                .orElseThrow(() -> new CustomException(ErrorCode.TEAM_NOT_FOUND, "Team not found with id: " + teamId));
        //이미 존재하는 팀원은 추가 못하게
        GitUser gitUser = gitUserRepository.findByGithubUserId(dto.getGithubUserId())
                .orElseThrow(() -> new IllegalArgumentException("GitUser not found: id=" + dto.getGithubUserId()));

        if (teamMemberRepo.existsByTeam_TeamIdAndUser_GithubUserId(teamId, dto.getGithubUserId())) {
            throw new CustomException(ErrorCode.DUPLICATE_TEAM_MEMBER);
        }
        TeamMember teamMember = TeamMember.builder()
                .team(team)
                .user(new GitUser(dto.getGithubUserId()))
                .memberRole(dto.getMemberRole())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        teamMemberRepo.save(teamMember);
        return true;
    }

    @Override
    public Boolean deleteTeamMember(Integer teamMemberId) {
        TeamMember teamMember = teamMemberRepo.findByMemberId(teamMemberId)
                .orElseThrow(() -> new EntityNotFoundException("TeamMember not found: id=" + teamMemberId));
        teamMemberRepo.deleteById(teamMemberId);
        return true;
    }
}
