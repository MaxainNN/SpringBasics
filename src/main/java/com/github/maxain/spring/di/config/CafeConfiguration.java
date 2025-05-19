package com.github.maxain.spring.di.config;

import com.github.maxain.spring.di.beans.Kitchen;
import com.github.maxain.spring.di.beans.Waiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный класс Spring для настройки компонентов ресторана.
 * Определяет бины и сканирует компоненты в указанном пакете.
 */
@Configuration
@ComponentScan("com.github.maxain.spring.di")
public class CafeConfiguration {

    /**
     * Создает и возвращает бин официанта.
     *
     * @param kitchen кухня, которая будет внедрена в официанта
     * @return экземпляр официанта
     */
    @Bean
    public Waiter waiter(Kitchen kitchen){
        return new Waiter(kitchen);
    }
}
