package com.github.maxain.spring.aware.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Waiter implements ApplicationContextAware, BeanFactoryAware, EnvironmentAware {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;
    private Environment environment;

    public void takeOrder(String dish) {
        System.out.println("Waiter takes order");
        applicationContext.getBean(Chef.class).cook(dish);
//        beanFactory.getBean(Chef.class).cook(dish);
    }

    public void greetCustomer() {
        // Edit Configurations -> Environment variables -> Edit -> daytime=morning
        //String daytime = environment.getProperty("daytime");
        //System.out.println("Good " + daytime);
        System.out.println("Good morning!");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
