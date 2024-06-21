package com.zahid.htmx.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.zahid.htmx.model.Todo;

@SpringBootTest(classes = Todo.class)
class TodoJunitTest {

    @Test
    void testNewTodoCreation() {
        Todo testTodo = new Todo(8, "Learning JUnit Test for Spring Boot Application");
        testTodo.setIsCompleted(true);

        assertEquals("Learning JUnit Test for Spring Boot Application", testTodo.getTask(), "Todo name was not equal");
        // assertFalse(testTodo.getIsCompleted(), "Todo is completed");
        assertTrue(testTodo.getIsCompleted(), "Todo is not completed");
    }

}
