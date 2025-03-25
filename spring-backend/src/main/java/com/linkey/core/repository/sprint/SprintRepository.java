package com.linkey.core.repository.sprint;

import com.linkey.core.domain.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {
    Sprint save(Sprint sprint);
    Optional<Sprint> findById(Long sprintId);
}
