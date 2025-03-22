package com.linkey.core.repository.project.redis;

import com.linkey.core.domain.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRedisRepositoryCustom extends CrudRepository<Project, Long> {

}
