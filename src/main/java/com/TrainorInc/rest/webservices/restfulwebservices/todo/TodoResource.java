package com.TrainorInc.rest.webservices.restfulwebservices.todo;

import com.TrainorInc.rest.webservices.restfulwebservices.todo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class TodoResource {

    @Autowired
    private TodoService todoService;

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username)
    {
        return todoService.findAllTodosByUsername(username);
    }

    @GetMapping(path = "/users/{username}/upcomingtodos")
    public List<Todo> getUpcomingTodos(@PathVariable String username)
    {
        return todoService.findUpcomingTodosByUsername(username);
    }


    @GetMapping(path = "/users/{username}/todos/{id}")
    public Todo getTodoById(@PathVariable String username, @PathVariable Long id)
    {
        return todoService.findById(id).get();
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable String username,@PathVariable Long id)
    {
       todoService.deleteById(id);

       return ResponseEntity.noContent().build();

    }

    @PutMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodoById(@PathVariable String username,@PathVariable int id, @RequestBody Todo todoToUpdate)
    {
        todoToUpdate.setUsername(username);

        Todo returnedTodo = todoService.save(todoToUpdate);
        return new ResponseEntity<Todo>(returnedTodo, HttpStatus.OK);
    }

    @PostMapping(path = "/users/{username}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todoToSave)
    {
        todoToSave.setUsername(username);

        Todo createdTodo = todoService.save(todoToSave);
        //location
        //get current resource url
        ///users/{username}/todos/{id}
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTodo.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
