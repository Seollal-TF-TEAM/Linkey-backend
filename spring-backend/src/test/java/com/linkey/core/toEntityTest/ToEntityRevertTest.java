package com.linkey.core.toEntityTest;


import com.linkey.core.domain.dto.request.ReqCreateProjectDto;
import com.linkey.core.domain.dto.request.ReqCreateTeamDto;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.domain.enums.MemberRole;
import com.linkey.core.mapper.TeamMapper;
import com.linkey.core.mapper.TeamMapperImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ToEntityRevertTest {

    private final TeamMapper teamMapper = new TeamMapperImpl();

    @Test
    public void teamToEntityTest() {
        ReqCreateTeamDto createTeamDto = ReqCreateTeamDto.builder()
                .teamName("Linkey Dev Team")
                .teamDesc("Team responsible for core backend development.")
                .teamMembers(List.of(
                        ReqCreateTeamDto.SingleTeamMember.builder()
                                .githubUserId(101L)
                                .role(MemberRole.OWNER) // 혹은 MEMBER, MANAGER 등 enum 값
                                .build(),
                        ReqCreateTeamDto.SingleTeamMember.builder()
                                .githubUserId(102L)
                                .role(MemberRole.MEMBER)
                                .build()
                ))
                .build();
//        ReqCreateProjectDto projectDto = new ReqCreateProjectDto();

        Team testTeam = teamMapper.toEntity(createTeamDto);
        System.out.println(testTeam);

    }
}
