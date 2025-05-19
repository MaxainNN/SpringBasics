package com.github.maxain.spring.aware.config;

import com.github.maxain.spring.aware.beans.Chef;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.github.maxain.spring.aware")
public class ApplicationConfiguration {

    @Bean
    public Chef restaurantChef(){
        return new Chef();
    }

}
