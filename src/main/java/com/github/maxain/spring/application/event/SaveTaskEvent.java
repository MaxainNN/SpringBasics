package com.github.maxain.spring.application.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class SaveTaskEvent extends ApplicationEvent {
    public SaveTaskEvent(Object source) {
        super(source);
    }

    public SaveTaskEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
