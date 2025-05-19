package com.github.maxain.spring.di.beans;

import org.springframework.stereotype.Component;

/**
 * Компонент, представляющий клиента ресторана.
 * Делает заказы через официанта.
 */
@Component
public class Customer {

    private final Waiter waiter;

    /**
     * Создает нового клиента с зависимостью от официанта.
     *
     * @param waiter официант, который будет принимать заказы
     */
    public Customer(Waiter waiter) {
        this.waiter = waiter;
    }

    /**
     * Сделать заказ в ресторане.
     *
     * @param order блюдо или блюда, которые нужно заказать
     */
    public void makeOrder(String order) {
        System.out.println("Customer makes order: " + order);
        waiter.takeOrder(order);
    }
}
