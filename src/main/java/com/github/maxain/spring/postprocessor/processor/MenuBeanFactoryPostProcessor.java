package com.github.maxain.spring.postprocessor.processor;

import com.github.maxain.spring.postprocessor.beans.Food;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * Класс MenuBeanFactoryPostProcessor является BeanFactoryPostProcessor в Spring,
 * который модифицирует конфигурацию бинов до их создания. Он выполняет две основные задачи:
 * 1) Регистрирует новый синглтон-бин openTime (время открытия).
 * 2) Динамически создаёт и регистрирует бины типа Food (для мяса и пасты).
 * Класс реализует интерфейс BeanFactoryPostProcessor
 * BeanFactoryPostProcessor позволяет изменять метаданные бинов до их инстанцирования.
 * Метод postProcessBeanFactory() вызывается один раз при старте приложения, до создания любых бинов.
 */
@Component
public class MenuBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * Создаёт и регистрирует бин с именем "openTime" и значением LocalTime.of(10, 0) (10:00).
     * Это готовый объект (не фабрика), который будет доступен в контексте Spring как
     * <pre>{@code
     * @Autowired
     * private LocalTime openTime;
     * }</pre>
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerSingleton("openTime", LocalTime.of(10,0));

        addFoodBean("Meat", "Steak", (DefaultListableBeanFactory) beanFactory);
        addFoodBean("Pasta", "Pasta", (DefaultListableBeanFactory) beanFactory);
    }

    private void addFoodBean(String type, String dishName, DefaultListableBeanFactory beanFactory){
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Food.class);
        genericBeanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0,type);
        genericBeanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(1,dishName);

        // Регистрация бина в BeanFactory
        beanFactory.registerBeanDefinition(dishName.toLowerCase(),genericBeanDefinition);
    }
}
