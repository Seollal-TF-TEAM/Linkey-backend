package com.linkey.core.repository.sprint;

import com.linkey.core.domain.entity.Sprint;
import com.linkey.core.repository.sprint.custom.SprintRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer>, SprintRepositoryCustom {
}
