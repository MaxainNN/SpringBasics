package com.github.maxain.spring.event;

import com.github.maxain.spring.event.beans.Restaurant;
import com.github.maxain.spring.event.config.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Restaurant restaurant = context.getBean(Restaurant.class);
        restaurant.placeOrder("Salad");
        restaurant.placeOrder("Pasta");
    }
}
