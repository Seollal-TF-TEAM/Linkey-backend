package com.linkey.core.service.team;

import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.dto.TeamMemberDto;

import java.util.List;

public interface TeamService {
    TeamDto addTeam(TeamDto team);
    Boolean deleteTeam(Integer id);
    Boolean updateTeam(Integer id, TeamDto team);
    TeamDto getTeamById(Integer teamId);
    List<TeamMemberDto> getTeamMembers(Integer teamId);
    Boolean addTeamMember(Integer teamId, TeamMemberDto teamMember);
    Boolean deleteTeamMember(Integer teamMemberId);
}
