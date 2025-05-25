package com.github.maxain.spring.application.model;

import java.io.Serial;
import java.io.Serializable;

public class Task implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;

    private String description;

    private Boolean completed = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
