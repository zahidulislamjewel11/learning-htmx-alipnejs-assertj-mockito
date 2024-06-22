package com.zahid.htmx.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zahid.htmx.exception.EntityNotFoundException;
import com.zahid.htmx.model.Todo;
import com.zahid.htmx.repository.TodoRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/todos")
public class TodoRestController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("get/all")
    public ResponseEntity<List<Todo>> getAllEntities() {
        List<Todo> todos = todoRepository.findAll();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Todo> getEntityById(@PathVariable("id") Integer id) throws NoSuchElementException {
        List<Todo> todos = todoRepository.findAll();

        Todo fetchedTodo = fetchedTodo = todos.stream()
        .filter(todo -> todo.getId().equals(id))
        .findFirst().orElseThrow(() -> new NoSuchElementException("No Element found with id " + id));

        log.info("todo: {}", fetchedTodo);

        return new ResponseEntity<>(fetchedTodo, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Todo> addTodo(@RequestParam String task) {
        List<Todo> todos = todoRepository.findAll();

        Todo newTodo = new Todo();
        newTodo.setId(todos.size() + 1);
        newTodo.setTask(task);
        todos.add(newTodo);

        return new ResponseEntity<>(newTodo, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") int id, @RequestParam("task") String task) {
        List<Todo> todos = todoRepository.findAll();

        Todo fetchedTodo = todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst().get();
        fetchedTodo.setTask(task);

        return new ResponseEntity<>(fetchedTodo, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable int id) {
        List<Todo> todos = todoRepository.findAll();
        todos.removeIf(todo -> todo.getId().equals(id));

        log.info("todo count: {}", todos.size());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Todo>> searchTodos(@RequestParam String searchText) {
        List<Todo> todos = todoRepository.findAll();
        List<Todo> filteredTodos = todos.stream()
                .filter(todo -> todo.getTask().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(filteredTodos, HttpStatus.OK);
    }
}
