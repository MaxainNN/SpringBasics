package com.github.maxain.spring.di.beans;

import org.springframework.stereotype.Component;

/**
 * Компонент, представляющий кухню ресторана.
 * Отвечает за приготовление заказов.
 */
@Component
public class Kitchen {

    /**
     * Приготовить указанное блюдо.
     *
     * @param order название блюда для приготовления
     */
    public void cook(String order){
        System.out.println("Kitchen start cooking: " + order);
    }
}
