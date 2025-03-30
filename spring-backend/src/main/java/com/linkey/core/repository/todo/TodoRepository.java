package com.linkey.core.repository.todo;

import com.linkey.core.domain.entity.Todo;
import com.linkey.core.repository.todo.custom.TodoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoRepositoryCustom {

    Optional<Todo> findByTodoId(Long id); // 안전하게 Optional
    void deleteByTodoId(Long id); // 타입 통일
}
