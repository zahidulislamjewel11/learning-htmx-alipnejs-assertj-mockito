package com.zahid.htmx.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "task", "isCompleted"})
public class Todo {

    private Integer id;
    private String task;
    private Boolean isCompleted = Boolean.FALSE;

    public Todo(Integer id, String task) {
        this.id = id;
        this.task = task;
    }
}