package com.linkey.core.repository.todo;

import com.linkey.core.domain.dto.TodoDto;
import com.linkey.core.domain.entity.Todo;
import com.linkey.core.repository.todo.custom.TodoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>, TodoRepositoryCustom {

    List<Todo> getTodosBySprint_SprintId(Integer sprintId);

    Todo saveAll(List<Todo> todo);

    void deleteById(Long id);
}
