//package com.linkey.core.repository.todo;
//
//import com.linkey.core.domain.entity.Team;
//import com.linkey.core.domain.entity.Todo;
//import com.linkey.core.repository.todo.custom.TodoRepositoryCustom;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface TodoRepository extends JpaRepository<Todo, Long>, TodoRepositoryCustom {
//    Todo save(Todo todo);
//    Todo findByTeamId(Integer id);
//    void deleteByTeamId(Integer id);
//}
