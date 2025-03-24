package com.linkey.core.service.team;

import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.domain.entity.TeamMember;

import java.util.List;

public interface TeamService {
    public Boolean addTeam(TeamDto team);

    public Boolean deleteTeam(Integer id);

    public Boolean updateTeam(Integer id, TeamDto team);

    public TeamDto getTeamById(Integer id);

    public List<TeamMemberDto> getTeamMembers(Integer teamId);

    public Boolean addTeamMember(Integer teamId, TeamMemberDto teamMember);

    public Boolean deleteTeamMember(Integer teamMemberId);

}
