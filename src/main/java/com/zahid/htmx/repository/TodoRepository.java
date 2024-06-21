package com.zahid.htmx.repository;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import com.zahid.htmx.model.Todo;

@Repository
public class TodoRepository {
    
    
    public List<Todo> findAll() {
        
        List<Todo> todos = new ArrayList<>();

        todos.add(new Todo(1, "Learning HTMX"));
        todos.add(new Todo(2, "Exploring AlpineJS"));
        todos.add(new Todo(3, "Implementing NGINX as Load Balancer"));
        todos.add(new Todo(4, "Integrating SSL"));
        todos.add(new Todo(5, "Adding Grafana Monitoring"));
        todos.add(new Todo(6, "Adding AOP for Auditing"));
        todos.add(new Todo(7, "Implementing Role Management"));
        
        return todos;
    }
    
}
