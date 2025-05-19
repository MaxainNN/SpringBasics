package com.github.maxain.spring.di;

import com.github.maxain.spring.di.beans.Customer;
import com.github.maxain.spring.di.config.CafeConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Главный класс приложения, демонстрирующий работу ресторана.
 * Создает контекст Spring и инициирует процесс заказа.
 */
public class CafeApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CafeConfiguration.class);

        Customer customer = context.getBean("customer", Customer.class);
        customer.makeOrder("Salad and pizza");
    }
}
