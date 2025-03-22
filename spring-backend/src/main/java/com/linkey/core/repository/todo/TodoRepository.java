package com.linkey.core.repository.todo;

import com.linkey.core.domain.entity.Todo;
import com.linkey.core.repository.todo.custom.TodoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>, TodoRepositoryCustom {
}
