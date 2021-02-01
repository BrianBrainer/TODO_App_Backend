package com.TrainorInc.rest.webservices.restfulwebservices.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface TodoService extends JpaRepository<Todo, Long> {

    List<Todo> findAllTodosByUsername(String username);

    @Query(value="select * from todo where username = :username order by date asc Limit 3",
            nativeQuery = true)
    List<Todo> findUpcomingTodosByUsername(@Param("username") String username);
    //List<Todo> findAllByUsernameandCompleted(String username);
//    Logger logger = LoggerFactory.getLogger(TodoService.class);
//
//    List<Todo>getList();
//
//    Todo deleteTodoById(Long id);
//
//    Todo saveTodo(Todo todoToSave);
//
//    Todo findTodoById(Long id);
}
