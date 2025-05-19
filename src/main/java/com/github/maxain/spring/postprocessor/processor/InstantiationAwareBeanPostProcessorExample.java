package com.github.maxain.spring.postprocessor.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Класс реализует интерфейс InstantiationAwareBeanPostProcessor,
 * который расширяет стандартный BeanPostProcessor,
 * добавляя возможность вмешательства в процесс:
 * До фактического создания экземпляра бина
 * В момент обработки его свойств
 * После создания, но до инициализации
 * После полной инициализации
 */
@Component
public class InstantiationAwareBeanPostProcessorExample implements InstantiationAwareBeanPostProcessor {

    /**
     * Вызывается: при обработке свойств бина (полей, аннотированных @Value, @Autowired)
     * Возможности:
     * Модификация PropertyValues перед их применением
     * Добавление/удаление свойств
     * Типичное использование: динамическое изменение конфигурации
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor -> postProcessProperties");
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    /**
     * Вызывается: перед созданием экземпляра бина
     * Возможности:
     * Можно полностью заменить стандартный процесс создания, вернув собственный объект
     * Если возвращается не-null, стандартное создание бина пропускается
     * Типичное использование: создание прокси-объектов
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor -> postProcessBeforeInstantiation");
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    /**
     * Вызывается: после создания экземпляра, но ДО внедрения зависимостей
     * Возможности:
     * Возвращает boolean (продолжать ли обработку свойств)
     * Если false - Spring не будет обрабатывать свойства бина
     * Типичное использование: кастомная логика инициализации
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor -> postProcessAfterInstantiation");
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    /**
     * Вызывается: после внедрения зависимостей, но до init-методов
     * Возможности:
     * Модификация бина перед финальной инициализацией
     * Типичное использование: подготовка бина к работе
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor -> postProcessBeforeInitialization");
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * Вызывается: после всех init-методов
     * Возможности:
     * Финальная модификация бина
     * Замена бина прокси-объектом
     * Типичное использование: AOP, кэширование
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor -> postProcessAfterInitialization");
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
