package com.linkey.core.service.team;

import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.dto.request.ReqCreateTeamDto;
import com.linkey.core.domain.dto.response.ResTeamListDto;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.domain.entity.TeamMember;
import jakarta.transaction.Transactional;

import java.util.List;

public interface TeamService {
    public Boolean addTeam(ReqCreateTeamDto team);

    public Boolean deleteTeam(Integer id);

    public Boolean updateTeam(Integer id, TeamDto team);

    public ResTeamListDto getTeamById(Integer id);

    public ResTeamListDto getTeamMembers(Integer teamId);

    public Boolean addTeamMember(ReqCreateTeamDto team);

    public Boolean addTeamMember(Integer teamId, TeamMemberDto team);

    public Boolean deleteTeamMember(Integer teamMemberId);

}
