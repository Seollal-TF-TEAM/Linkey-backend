package com.linkey.core.repository.commit;

import com.linkey.core.domain.entity.Commit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitRepository extends JpaRepository<Commit, Integer> , CommitRepositoryCustom{
}
