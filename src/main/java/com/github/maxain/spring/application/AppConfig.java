package com.github.maxain.spring.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.github.maxain.spring.application")
@PropertySource("classpath:tasks-application.properties")
public class AppConfig {
}
