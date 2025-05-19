package com.github.maxain.spring.postprocessor;

import com.github.maxain.spring.postprocessor.beans.Restaurant;
import com.github.maxain.spring.postprocessor.config.ApplicationConfiguration;
import com.github.maxain.spring.postprocessor.beans.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        Waiter waiter = context.getBean(Waiter.class);
        waiter.takeOrder();

        Restaurant restaurant = context.getBean(Restaurant.class);
        restaurant.printInfo();
    }
}
