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

import static org.junit.jupiter.api.Assertions.*;
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
    void testGetUserProjects() {
        // 더미데이터 생성
        Team team = new Team();
        List<Project> projects = List.of(
                new Project(
                        "test1",
                        "test1 project",
                        team,
                        "https://test.repo"
                )
        );
//        when(projectRepository.findByProjectId(1)).thenReturn(projects);
//
//        // 테스트를 위해 메소드 실행
//        List<ProjectDto> foundProject = projectService.getUserProjects(1);

        // 테스트 검증
        // 찾은 project List에 요소가 0개가 아닌지
//        assertFalse(foundProject.isEmpty());
    }
}