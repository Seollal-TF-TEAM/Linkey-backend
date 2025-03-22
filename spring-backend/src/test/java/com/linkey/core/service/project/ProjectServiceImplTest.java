package com.linkey.core.service.project;

import com.linkey.core.domain.dto.ProjectDto;
import com.linkey.core.domain.entity.Project;
import com.linkey.core.domain.entity.Team;
import com.linkey.core.repository.project.custom.ProjectRepositoryImpl;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Transactional
@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    // test를 위한 가짜 projectRepository 컨텍스트 생성
    // when 절을 이용해 컨텍스트의 동작 방식을 지정해 줄 수 있다.
    @Mock
    private ProjectRepositoryImpl projectRepository;

    // Mock 컨텍스트를 주입하여 사용할 실제 인스턴스를 지정
    @InjectMocks
    private ProjectServiceImpl projectService;

    @Test
    @DisplayName("ProjcetServiceImpl.getUserProjects 기본 동작 test")
    void testGetProjectsByGithubUserId() {
        // 더미데이터 생성
        Team team = new Team();
        List<Project> projects = List.of(
                new Project(
                        "test1",
                        "test1 project",
                        team,
                        "https://test1.repo"
                )
        );
//        when(projectRepository.findProjectsByGithubUserId(1L)).thenReturn(projects);
        when(projectRepository.findByUserId(1L)).thenReturn(projects);

        // 테스트를 위해 메소드 실행
        List<ProjectDto> foundProject = projectService.getProjectsByGithubUserId(1L);

        // 테스트 검증
        // 찾은 project List에 요소가 0개가 아닌지
        assertFalse(foundProject.isEmpty());
    }

    @Test
    @DisplayName("ProjectServiceImpl.getProjectByProjectId 기본 동작 test")
    void getProjectByProjectId() {
        Team team = new Team();
        Project project = new Project(
                "test2",
                "test2 project",
                team,
                "https://test2.repo"
        );

        when(projectRepository.findById(1)).thenReturn(Optional.of(project));

        ProjectDto foundProject = projectService.getProjectByProjectId(1);

        assert(project.getProjectId() == foundProject.getProjectId());
        assert(project.getProjectName().equals(foundProject.getProjectName()));
        assert(project.getProjectDesc().equals(foundProject.getProjectDesc()));
    }

    @Test
    @DisplayName("ProjectServiceImpl.createProject 기본 동작 test")
    void createProject() {
        Team team = new Team();

        Project project = new Project(
                "test3",
                "test3 project",
                team,
                "https://test3.repo"
        );
        project.setProjectId(1);

        when(projectRepository.save(any(Project.class))).thenReturn(project);

        Integer result = projectService.createProject(
                ProjectDto.builder()
                        .projectName("test3")
                        .projectDesc("test3 project")
                        .team(team)
                        .githubRepoUrl("https://test3.repo")
                        .build()
        );

        assertEquals(1, result);
    }

    @Test
    void updateProject() {
    }

    @Test
    void deleteProject() {
    }
}