package com.github.maxain.spring.application.event;

import com.github.maxain.spring.application.service.TaskService;
import com.github.maxain.spring.application.event.SaveTaskEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SaveTasksEventListener {

    @Value("${app.tasks-file-path}")
    private String filePath;

    private final TaskService taskService;

    public SaveTasksEventListener(TaskService taskService) {
        this.taskService = taskService;
    }

    @EventListener(SaveTaskEvent.class)
    public void onEvent(SaveTaskEvent event) {
        System.out.println("Save tasks...");
        taskService.saveTasks(filePath);
    }
}
