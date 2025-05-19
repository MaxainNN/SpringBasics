package com.github.maxain.spring.aware;

import com.github.maxain.spring.aware.beans.Menu;
import com.github.maxain.spring.aware.beans.Waiter;
import com.github.maxain.spring.aware.config.ApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        Waiter waiter = context.getBean(Waiter.class);
        waiter.takeOrder("Salad");
        waiter.greetCustomer();

        context.getBean(Menu.class).printMenu();
    }
}
