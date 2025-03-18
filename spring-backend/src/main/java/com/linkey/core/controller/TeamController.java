package com.linkey.core.controller;


import com.linkey.core.domain.entity.Team;
import com.linkey.core.domain.entity.TeamMember;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/teams")
public class TeamController {

//    private final

    @GetMapping("/getTeam")
    public Team getTeam() {
        return null;
    }

    @GetMapping("/getMember")
    public List<TeamMember> getTeamMember(){
        return null;
    }

    @PostMapping("/createTeam")
    public boolean createTeam(Team team) {
        return false;
    }

    @PostMapping("/createMember")
    public boolean createMember(TeamMember teamMember) {
        return false;
    }

    @PostMapping("/deleteTeam")
    public boolean deleteTeam(Integer teamId) {
        return false;
    }

    @PostMapping("/deleteMember")
    public boolean deleteMember(Integer teamMemberId) {
        return false;
    }
}
