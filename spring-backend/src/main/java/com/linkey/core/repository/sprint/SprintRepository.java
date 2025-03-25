package com.linkey.core.repository.sprint;

import com.linkey.core.domain.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer> {
    //Sprint findByProject_ProjectId(Long projectId);
    Sprint save(Sprint sprint);
}
