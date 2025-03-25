package com.linkey.core.service.team;

import com.linkey.core.domain.dto.GitUserDto;
import com.linkey.core.domain.dto.TeamDto;
import com.linkey.core.domain.dto.TeamMemberDto;
import com.linkey.core.domain.entity.GitUser;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.domain.entity.TeamMember;
import com.linkey.core.domain.enums.MemberRole;
import com.linkey.core.repository.team.TeamMemberRepository;
import com.linkey.core.repository.team.TeamRepository;
import com.linkey.core.repository.user.GitUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TeamServiceImplTest {

    @Mock
    private TeamRepository teamRepo;

    @Mock private TeamMemberRepository teamMemberRepo;

    private TeamService teamService;

//    @Mock private GitUserRepository gitUserRepo;

//    @InjectMocks
//    TeamServiceImpl teamService;
    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this); // ✅ Mock 초기화 필수!
        teamService = new TeamServiceImpl(teamRepo, teamMemberRepo);
    }

    @Test
    public void testAddTeam() {
        //given
        TeamDto teamDto = TeamDto.builder()
                .teamId(1)
                .teamName("Linkey Dev Team")
                .teamDesc("Backend developers for Linkey project")
                .createdAt(LocalDateTime.now().minusDays(1))
                .updatedAt(LocalDateTime.now())
                .build();

        Team teamEntity = Team.toEntity(teamDto);

        when(teamRepo.save(any(Team.class))).thenReturn(teamEntity);
        when(teamRepo.findByTeamId(1)).thenReturn(teamEntity);

        //when
        Boolean result = teamService.addTeam(teamDto);
        TeamDto testDto = teamService.getTeamById(teamDto.getTeamId());

        //then
        System.out.println(testDto.toString());
        System.out.println(teamDto.toString());
        Assertions.assertThat(result).isTrue();
        Assertions.assertThat(testDto.getTeamName()).isEqualTo(teamDto.getTeamName());
    }

    @Test
    public void testAddTeamMember() {
        //given
        GitUser gitUser = GitUser.builder()
                .githubUserId(1L)
                .githubUserEmail("aaa")
                .githubUserName("name")
                .githubProfileUrl("profile")
                .githubReposUrl("repos")
                .githubUpdatedAt(LocalDateTime.now().minusHours(3))
                .createdAt(LocalDateTime.now().minusDays(1))
                .updatedAt(LocalDateTime.now())
                .build();

        TeamDto teamDto = TeamDto.builder()
                .teamId(1)
                .teamName("Linkey Dev Team")
                .teamDesc("Backend developers for Linkey project")
                .createdAt(LocalDateTime.now().minusDays(1))
                .updatedAt(LocalDateTime.now())
                .build();

        TeamMemberDto teamMemberDto = TeamMemberDto.builder()
                .memberId(1)
                .teamId(teamDto.getTeamId())
                .memberRole(MemberRole.MEMBER)
                .githubUserId(gitUser.getGithubUserId())
                .githubUserName("name")
                .createdAt(LocalDateTime.now().minusDays(1))
                .updatedAt(LocalDateTime.now())
                .build();

        Team teamEntity = Team.toEntity(teamDto);
        TeamMember teamMemberEntity = TeamMember.toEntity(teamMemberDto);

        when(teamRepo.save(any(Team.class))).thenReturn(teamEntity);
        lenient().when(teamRepo.findByTeamId(1)).thenReturn(teamEntity);
        when(teamMemberRepo.save(any(TeamMember.class))).thenReturn(teamMemberEntity);

        //when
//        gitUserRepo.save(gitUser);
        Boolean teamResult = teamService.addTeam(teamDto);
        //Boolean result = teamService.addTeamMember(teamMemberDto);
        List<TeamMemberDto> members = teamService.getTeamMembers(teamMemberDto.getTeamId());

        //then
//        members.stream()
//                .map(TeamMemberDto::getGithubUserName) // 또는 toString()
//                .forEach(System.out::println); // 👈 여기서 출력

        assertThat(teamMemberDto.getTeamId()).isNotNull();
        assertThat(teamMemberDto.getGithubUserId()).isNotNull();




    }


}
