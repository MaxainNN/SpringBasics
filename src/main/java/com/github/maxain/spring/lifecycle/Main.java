package com.github.maxain.spring.lifecycle;

import com.github.maxain.spring.lifecycle.beans.CoffeeShop;
import com.github.maxain.spring.lifecycle.config.LifeCycleConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);

//        createCoffeeShop(context);
//        createCoffeeShop(context, "Latte");
        createCoffeeShop(context, "Latte", "sugar");
        createCoffeeShop(context, "Latte", "milk");
//        createCoffeeShop(context, "Latte", "non-existed");

        context.close();
        System.out.println("Context is closed");
    }

    private static void createCoffeeShop(ApplicationContext context) {
        CoffeeShop shop = context.getBean(CoffeeShop.class);
        shop.makeCoffee();
    }

    private static void createCoffeeShop(ApplicationContext context, String coffeeType) {
        CoffeeShop shop = context.getBean(CoffeeShop.class);
        shop.makeCoffee(coffeeType);
    }

    private static void createCoffeeShop(ApplicationContext context, String coffeeType, String ingredient) {
        CoffeeShop shop = context.getBean(CoffeeShop.class);
        shop.makeCoffee(coffeeType, ingredient);
    }

}
