package com.linkey.core.controller;

import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.service.team.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/teams/")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    // 팀 리스트
    @GetMapping("teamList")
    @ResponseBody
    public TeamDto getTeamList(@RequestParam("githubUserId") Long id) {
        return null;
    }

  // 팀 상세
    @GetMapping("teamDetail")
    @ResponseBody
    public TeamDto getTeamDetail(@RequestParam("teamId") Integer teamId) {
        return teamService.getTeamById(teamId);
    }

    // 팀 추가
    @PostMapping("createTeam")
    @ResponseBody
    public Boolean createTeam(@RequestBody TeamDto teamDto) {
        return teamService.addTeam(teamDto);
    }

    // 팀 수정
    @PatchMapping("updateTeam")
    @ResponseBody
    public Boolean updateTeam(@RequestParam("teamId") Integer teamId, @RequestBody TeamDto teamDto) {
        return teamService.updateTeam(teamId, teamDto);
    }

    // 팀 삭제
    @DeleteMapping("deleteTeam")
    @ResponseBody
    public Boolean deleteTeam(@RequestParam("teamId") Integer teamId) {
        return teamService.deleteTeam(teamId);
    }



    // 팀 멤버 리스트 조회
    @GetMapping("members/teamMemberList")
    @ResponseBody
    public List<TeamMemberDto> getTeamMembers(@RequestParam("teamId") Integer teamId) {
        return teamService.getTeamMembers(teamId);
    }

    // 팀 멤버 조회
    @GetMapping("members/teamMemberDetail")
    @ResponseBody
    public List<TeamMemberDto> getTeamMember(@RequestParam("teamId") Integer teamId, @RequestParam("githubUserId") Long githubUserId) {
        return null;
    }

    // 팀 멤버 추가
    @PostMapping("members/createTeamMember")
    @ResponseBody
    public Boolean addTeamMember(@RequestParam("teamId") Integer teamId,
                                 @RequestBody TeamMemberDto teamMemberDto) {
        return teamService.addTeamMember(teamId, teamMemberDto);
    }

    // 팀 멤버 삭제
    @DeleteMapping("members/deleteTeamMember")
    @ResponseBody
    public Boolean deleteTeamMember(@RequestParam("memberId") Integer memberId) {
        return teamService.deleteTeamMember(memberId);
    }
}
