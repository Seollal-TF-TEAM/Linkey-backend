package com.linkey.core.controller;

import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.dto.response.ResWrapper;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.service.team.TeamService;
import jakarta.validation.Valid;
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
    public ResWrapper getTeamList(@RequestParam("githubUserId") Long githubUserId) {
        return ResWrapper.resSuccess(teamService.getTeamMembersByUser(githubUserId));
    }

  // 팀 상세
    @GetMapping("teamDetail")
    @ResponseBody
    public ResWrapper getTeamDetail(@RequestParam("teamId") Integer teamId) {
        return ResWrapper.resSuccess(teamService.getTeamById(teamId));
    }

    // 팀 추가
    @PostMapping("createTeam")
    @ResponseBody
    public ResWrapper createTeam(@Valid @RequestBody TeamDto teamDto) {
        return ResWrapper.resSuccess(teamService.addTeam(teamDto));
    }

    // 팀 수정
    @PatchMapping("updateTeam")
    @ResponseBody
    public ResWrapper updateTeam(@RequestParam("teamId") Integer teamId
                                ,@Valid @RequestBody TeamDto teamDto) {
        return ResWrapper.resSuccess(teamService.updateTeam(teamId, teamDto));
    }

    // 팀 삭제
    @DeleteMapping("deleteTeam")
    @ResponseBody
    public ResWrapper deleteTeam(@RequestParam("teamId") Integer teamId) {
        return ResWrapper.resSuccess(teamService.deleteTeam(teamId));
    }

    // 팀 멤버 리스트 조회
    @GetMapping("members/teamMemberList")
    @ResponseBody
    public ResWrapper getTeamMembers(@RequestParam("teamId") Integer teamId) {
        return ResWrapper.resSuccess(teamService.getTeamMembers(teamId));
    }

    // 팀 멤버 조회
    @GetMapping("members/teamMemberDetail")
    @ResponseBody
    public ResWrapper getTeamMember(@RequestParam("teamId") Integer teamId,
                                    @RequestParam("githubUserId") Long githubUserId) {
        return null;
    }

    // 팀 멤버 추가
    @PostMapping("members/createTeamMember")
    @ResponseBody
    public ResWrapper addTeamMember(@RequestParam("teamId") Integer teamId,
                                    @Valid @RequestBody TeamMemberDto teamMemberDto) {
        return ResWrapper.resSuccess(teamService.addTeamMember(teamId, teamMemberDto));
    }

    // 팀 멤버 삭제
    @DeleteMapping("members/deleteTeamMember")
    @ResponseBody
    public ResWrapper deleteTeamMember(@RequestParam("memberId") Integer memberId) {
        try {
            boolean result = teamService.deleteTeamMember(memberId);
            return ResWrapper.resSuccess(result);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }
}
