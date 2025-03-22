package com.linkey.core.repository.user.redis;

import com.linkey.core.domain.entity.GitUser;
import org.springframework.data.repository.CrudRepository;

public interface GitUserRedisRepository extends CrudRepository<GitUser, Long> {

}
