package com.github.maxain.spring.postprocessor.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

/**
 * Класс Restaurant является Spring-бином (компонентом), который представляет ресторан с
 * временем открытия и меню, состоящим из списка блюд (Food). Он использует внедрение
 * зависимостей через конструктор (Constructor injection)
 */
@Component
public class Restaurant {

    private final LocalTime openTime;

    private final List<Food> menu;

    /**
     * Аннотация @Autowired указывает Spring, что зависимости (LocalTime и List<Food>)
     * нужно внедрить через конструктор.
     * Поскольку openTime был зарегистрирован как синглтон (registerSingleton), Spring передаст его сюда.
     * List<Food> будет содержать все бины типа Food, которые есть в контексте
     * (например, steak и pasta, созданные в MenuBeanFactoryPostProcessor).
     */
    @Autowired
    public Restaurant(LocalTime openTime, List<Food> menu){
        this.openTime = openTime;
        this.menu = menu;
    }

    public void printInfo(){
        System.out.println("Open time is " + openTime);
        System.out.println("Restaurant menu: " + menu);
    }
}
