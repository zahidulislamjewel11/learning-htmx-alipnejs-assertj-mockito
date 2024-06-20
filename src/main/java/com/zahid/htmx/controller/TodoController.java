package com.zahid.htmx.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Controller
@RequestMapping("/todos")
public class TodoController {

    private List<Todo> todos = new ArrayList<>();

    @GetMapping
    public String getTodos(Model model) {
        model.addAttribute("todos", todos);
        model.addAttribute("todoCount", todos.size());
        return "todo/todo-list";
    }

    @PostMapping("/add")
    @HxRequest
    public HtmxResponse addTodo(@RequestParam String task, RedirectAttributes redirectAttributes, Model model) {
        Todo newTodo = new Todo();
        newTodo.setId(todos.size() + 1);
        newTodo.setTask(task);
        todos.add(newTodo);
        redirectAttributes.addFlashAttribute("message", "Task added successfully!");
        model.addAttribute("todos", todos);
        model.addAttribute("todoCount", todos.size());
        model.addAttribute("message", "Todo added successfully!");

        return HtmxResponse.builder()
                .view("todo/todo-list :: todoItems")
                .view("todo/todo-list :: todoCount")
                .view("todo/todo-list :: message")
                .view("todo/todo-fragment :: addTodoForm")
                .build();
    }

    @GetMapping("/edit/{id}")
    public String updateTodoForm(@PathVariable("id") int id, Model model) {
        Todo fetchedTodo = todos.stream()
        .filter(todo -> todo.getId() == id)
        .findFirst().get();
        model.addAttribute("todo", fetchedTodo); 

        return "todo/todo-fragment :: updateTodoForm";
    }

    @PostMapping("/edit/{id}")
    public String updateTodo(@PathVariable("id") int id, @RequestParam("task") String task, Model model) {
        Todo fetchedTodo = todos.stream()
        .filter(todo -> todo.getId() == id)
        .findFirst().get();
        fetchedTodo.setTask(task);
        
        model.addAttribute("todo", fetchedTodo); 

        return "todo/todo-fragment :: readonlyTodo";
    }

    @GetMapping("/cancel/{id}")
    public String cancelTodo(@PathVariable("id") int id, Model model) {
        Todo fetchedTodo = todos.stream()
        .filter(todo -> todo.getId() == id)
        .findFirst().get();

        model.addAttribute("todo", fetchedTodo); 

        return "todo/todo-fragment :: readonlyTodo";
    }

    @HxRequest
    @DeleteMapping("/delete/{id}")
    public HtmxResponse deleteTodo(@PathVariable int id, Model model) {
        todos.removeIf(todo -> todo.getId() == id);
        model.addAttribute("todos", todos);
        model.addAttribute("todoCount", todos.size());
        model.addAttribute("message", "Todo deleted successfully!");

        log.info("todo count: {}", todos.size());

        return HtmxResponse.builder()
                .view("todo/todo-list :: todoCount")
                .view("todo/todo-list :: message")
                .view("todo/todo-fragment :: addTodoForm")
                .build();
    }

    @PostMapping("/search")
    @HxRequest
    public HtmxResponse searchTodos(@RequestParam String searchText, Model model) {
        List<Todo> filteredTodos = todos.stream()
                .filter(todo -> todo.getTask().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());

        model.addAttribute("todos", filteredTodos);
        model.addAttribute("todoCount", filteredTodos.size());

        return HtmxResponse.builder()
                .view("todo/todo-list :: todoItems")
                .view("todo/todo-fragment :: addTodoForm")
                .view("todo/todo-list :: todoCount")
                .build();
    }

    // Dummy data initialization
    @PostConstruct
    private void init() {
        todos.add(new Todo(1, "Learning HTMX"));
        todos.add(new Todo(2, "Exploring AlpineJS"));
        todos.add(new Todo(3, "Implementing NGINX as Load Balancer"));
        todos.add(new Todo(4, "Integrating SSL"));
        todos.add(new Todo(5, "Adding Grafana Monitoring"));
        todos.add(new Todo(6, "Adding AOP for Auditing"));
        todos.add(new Todo(7, "Implementing Role Management"));
    }

    static class Todo {
        private int id;
        private String task;

        // getters and setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTask() {
            return task;
        }

        public void setTask(String task) {
            this.task = task;
        }

        public Todo() {
        }

        public Todo(int id, String task) {
            this.id = id;
            this.task = task;
        }
    }
}
