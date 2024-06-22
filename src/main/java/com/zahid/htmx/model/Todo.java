package com.zahid.htmx.model;

import groovy.transform.ToString;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "task", "isCompleted"})
@Entity
@Table(name = "todo")
public class Todo {

    @Id
    private Integer id;
    private String task;
    private Boolean isCompleted = Boolean.FALSE;

    public Todo(Integer id, String task) {
        this.id = id;
        this.task = task;
    }
}