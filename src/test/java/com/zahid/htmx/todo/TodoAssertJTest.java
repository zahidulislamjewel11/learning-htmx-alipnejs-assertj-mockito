package com.zahid.htmx.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.zahid.htmx.model.Todo;

@SpringBootTest(classes = Todo.class)
class TodoAssertJTest {

    @Test
    void testNewTodoCreation() {
        Todo testTodo = new Todo(8, "Learning JUnit Test for Spring Boot Application");
        testTodo.setIsCompleted(true);

        assertThat(testTodo.getTask())
                .startsWith("Learning")
                .endsWith("Application")
                .contains("Spring Boot")
                .isEqualTo("Learning JUnit Test for Spring Boot Application");

    }

    @Test
    void testTodoEqual() {
        Todo firstTodo = new Todo(9, "Learning JUnitt");
        Todo secondTodo = new Todo(9, "Learning JUnitt");

        assertThat(firstTodo)
                .isEqualTo(secondTodo);
    }

    @Test
    void testTodoNotEqual() {
        Todo testNgTodo = new Todo(10, "Learning TestNG");
        Todo assertJTodo = new Todo(11, "Learning AssertJ");

        assertThat(testNgTodo)
                .isNotEqualTo(assertJTodo);
    }

}
