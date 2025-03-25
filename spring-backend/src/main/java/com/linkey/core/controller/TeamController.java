package com.linkey.core.controller;

import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.dto.request.ReqCreateTeamDto;
import com.linkey.core.domain.dto.response.ResTeamListDto;
import com.linkey.core.service.team.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // 팀 리스트
    @GetMapping("/{id}")
    @ResponseBody
    public ResTeamListDto getTeam(@PathVariable Integer id) {
        return teamService.getTeamById(id);
    }

    // 팀 추가
    @PostMapping
    @ResponseBody
    public Boolean createTeam(@RequestBody ReqCreateTeamDto teamDto) {
        return teamService.addTeam(teamDto);
    }

    // 팀 수정
    @PatchMapping("/{id}")
    @ResponseBody
    public Boolean updateTeam(@PathVariable Integer id, @RequestBody TeamDto teamDto) {
        return teamService.updateTeam(id, teamDto);
    }

    // 팀 삭제
    @DeleteMapping("/{id}")
    @ResponseBody
    public Boolean deleteTeam(@PathVariable Integer id) {
        return teamService.deleteTeam(id);
    }

    // 팀 멤버
    @GetMapping("/{teamId}/members")
    @ResponseBody
    public ResTeamListDto getTeamMembers(@PathVariable Integer teamId) {
        return teamService.getTeamMembers(teamId);
    }

    // 팀 멤버 추가
    @PostMapping("/{teamId}/members")
    @ResponseBody
    public Boolean addTeamMember(@PathVariable Integer teamId,
                                 @RequestBody TeamMemberDto teamMemberDto) {
        return teamService.addTeamMember(teamId, teamMemberDto);
    }

    // 팀 멤버 삭제
    @DeleteMapping("/members/{memberId}")
    @ResponseBody
    public Boolean deleteTeamMember(@PathVariable Integer memberId) {
        return teamService.deleteTeamMember(memberId);
    }
}
