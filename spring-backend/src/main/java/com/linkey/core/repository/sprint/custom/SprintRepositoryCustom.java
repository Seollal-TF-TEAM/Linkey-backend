package com.linkey.core.repository.sprint.custom;

import com.linkey.core.domain.entity.Sprint;

import java.util.List;

public interface SprintRepositoryCustom {
    List<Sprint> findSprintsByProjectId(int projectId);
}