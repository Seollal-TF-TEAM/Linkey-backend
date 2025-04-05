package com.linkey.core.service.team;

import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.dto.request.ReqCreateTeamDto;

import java.util.List;

public interface TeamService {
    TeamDto addTeam(TeamDto team);
    Boolean deleteTeam(Integer id);
    TeamDto updateTeam(Integer id, TeamDto team);
    TeamDto getTeamById(Integer teamId);
    List<TeamMemberDto> getTeamMembers();
    List<TeamMemberDto> getTeamMembersByTeamId(Integer teamId);
    List<TeamMemberDto> getTeamMembersByUser(Long githubUserId);
    Boolean addTeamMember(Integer teamId, TeamMemberDto teamMember);
//    Boolean addDtoTeamMember(Integer teamId, List<Long> membersId);
    Boolean deleteTeamMember(Integer teamMemberId);
}
