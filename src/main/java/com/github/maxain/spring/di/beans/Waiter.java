package com.github.maxain.spring.di.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Класс, представляющий официанта в ресторане.
 * Принимает заказы от клиентов и передает их на кухню.
 * В процессе изучения были рассмотеры варианты создания и
 * использования бинов с аннотациями @Component и @Autowired
 */
//@Component
public class Waiter {

    private final Kitchen kitchen;

    /**
     * Создает нового официанта с зависимостью от кухни.
     *
     * @param kitchen кухня, на которую будут передаваться заказы
     */
    public Waiter(Kitchen kitchen){
        this.kitchen = kitchen;
    }

    /**
     * Принять заказ от клиента и передать его на кухню.
     *
     * @param order заказ, который нужно приготовить
     */
    public void takeOrder(String order){
        System.out.println("Waiter takes order: " + order);
        kitchen.cook(order);
    }

//    @Autowired
//    public void setKitchen(Kitchen kitchen){
//        this.kitchen = kitchen;
//    }
}
