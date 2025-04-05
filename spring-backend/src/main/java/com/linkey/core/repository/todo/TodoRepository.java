package com.linkey.core.repository.todo;

import com.linkey.core.domain.dto.TodoDto;
import com.linkey.core.domain.entity.Todo;
import com.linkey.core.repository.todo.custom.TodoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoRepositoryCustom {

    Optional<Todo> findByTodoId(Long id);

    void deleteByTodoId(Long id);

    List<Todo> findBySprint_SprintId(Long sprintId);
}
