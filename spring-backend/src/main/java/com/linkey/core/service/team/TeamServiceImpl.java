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
    public Boolean addTeam(ReqCreateTeamDto teamDto) {
//        Team teamEntity = Team.toEntity(teamDto);
//        TeamMember teamMemberEntity = TeamMember.toEntity(teamDto);
//        Team saveTeam = Optional.of(teamRepo.save(teamEntity))
//                .orElseThrow(() -> new IllegalArgumentException("save Fail"));

        userResolver.getUserId()

        return true;
    }

    @Override
    public Boolean deleteTeam(Integer id) {
        Optional<Team> teamOptional = Optional.ofNullable(teamRepo.findByTeamId(id));

        Team team = teamOptional.orElseThrow(() ->
                new EntityNotFoundException("Team not found with id: " + id)
        );

        teamRepo.deleteByTeamId(id);
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
    public ResTeamListDto getTeamById(Integer id) {
        Team team = teamRepo.findByTeamId(id);
        return TeamDto.fromEntity(team);
    }

    @Override
    public ResTeamListDto getTeamMembers(Integer teamId) {
//        ResTeamListDto teamMembers = teamMemberRepo.findTeamMembersByTeam_TeamId(teamId);
//        return teamMembers;
        return null;
    }

    @Override
    public Boolean addTeamMember(ReqCreateTeamDto team) {
        return null;
    }

    @Transactional
    @Override
    public Boolean addTeamMember(Integer teamId, TeamMemberDto dto) {
        Team team = teamRepo.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team not found: id=" + teamId));

        //이미 존재하는 팀원은 추가 못하게
        GitUser gitUser = gitUserRepository.findByGithubUserId(dto.getGithubUserId())
                .orElseThrow(() -> new IllegalArgumentException("GitUser not found: id=" + dto.getGithubUserId()));

        boolean isDuplicate = teamMemberRepo.existsByTeam_TeamIdAndUser_GithubUserId(teamId, dto.getGithubUserId());
        if (isDuplicate) {
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
        teamMemberRepo.deleteById(teamMemberId);
        return true;
    }
}
