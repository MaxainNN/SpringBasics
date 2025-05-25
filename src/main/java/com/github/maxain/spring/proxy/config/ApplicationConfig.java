package com.github.maxain.spring.proxy.config;

import com.github.maxain.spring.proxy.beans.Customer;
import com.github.maxain.spring.proxy.beans.IWaiter;
import com.github.maxain.spring.proxy.beans.Waiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.github.maxain.spring.proxy")
public class ApplicationConfig {

    @Bean
    public IWaiter john() {
        return new Waiter("John");
    }

    @Bean
    public Customer andrew() {
        return new Customer("Andrew");
    }

    @Bean
    public Customer julia() {
        return new Customer("Julia");
    }

    @Bean
    public Customer nina() {
        return new Customer("Nina");
    }
}
