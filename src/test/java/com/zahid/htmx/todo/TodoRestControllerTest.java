package com.zahid.htmx.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zahid.htmx.controller.TodoRestController;
import com.zahid.htmx.model.Todo;
import com.zahid.htmx.repository.TodoRepository;

@WebMvcTest(TodoRestController.class)
class TodoRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TodoRepository todoRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testFindAllTodos() throws Exception {
        List<Todo> todos = List.of(
                new Todo(1, "Learning HTMX"),
                new Todo(2, "Exploring AlpineJS"),
                new Todo(3, "Implementing NGINX as Load Balancer"),
                new Todo(4, "Integrating SSL"));

        Mockito.when(todoRepository.findAll()).thenReturn(todos);

        MvcResult mvcResult = mockMvc.perform(get("/api/todos")).andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    void testFindAllTodosWithoutAssert() throws Exception {
        List<Todo> todos = List.of(
                new Todo(1, "Learning HTMX"),
                new Todo(2, "Exploring AlpineJS"),
                new Todo(3, "Implementing NGINX as Load Balancer"),
                new Todo(4, "Integrating SSL"));

        Mockito.when(todoRepository.findAll()).thenReturn(todos);

        mockMvc.perform(get("/api/todos"))
                .andExpect(status().isOk());

    }

    @Test
    void testFindAllTodosJson() throws Exception {
        List<Todo> todos = List.of(
                new Todo(1, "Learning HTMX"),
                new Todo(2, "Exploring AlpineJS"),
                new Todo(3, "Implementing NGINX as Load Balancer"),
                new Todo(4, "Integrating SSL"));

        Mockito.when(todoRepository.findAll()).thenReturn(todos);

        mockMvc.perform(get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(todos)));

    }

    @Test
    void testFindAllTodosJsonExpectAll() throws Exception {
        List<Todo> todos = List.of(
                new Todo(1, "Learning HTMX"),
                new Todo(2, "Exploring AlpineJS"),
                new Todo(3, "Implementing NGINX as Load Balancer"),
                new Todo(4, "Integrating SSL"));

        Mockito.when(todoRepository.findAll()).thenReturn(todos);

        mockMvc.perform(get("/api/todos"))
                .andExpectAll(
                        status().isOk(),
                        content().json(objectMapper.writeValueAsString(todos)));

    }
}
