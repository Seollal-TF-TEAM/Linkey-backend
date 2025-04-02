package com.linkey.core.repository.sprint;

import com.linkey.core.domain.entity.Sprint;
import com.linkey.core.repository.sprint.custom.SprintRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<Sprint, Long>, SprintRepositoryCustom {

}
