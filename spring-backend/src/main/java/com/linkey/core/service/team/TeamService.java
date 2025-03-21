package com.linkey.core.service.team;

import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.domain.entity.TeamMember;

import java.util.List;

public interface TeamService {
    public Boolean addTeam(Team team);

    public Boolean deleteTeam(Integer id);

    public Boolean updateTeam(Team team);

    public TeamDto getTeamById(Integer id);

    public List<TeamMember> getTeamMembers(Integer teamId);

    public Boolean addTeamMember(TeamMember teamMember);

    public Boolean deleteTeamMember(Integer teamMemberId);

}
