package com.github.maxain.spring.lifecycle.config;

import com.github.maxain.spring.lifecycle.beans.IngredientFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.github.maxain.spring.lifecycle")
public class LifeCycleConfiguration {

//    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
//    public CoffeeShop coffeeShop(ObjectProvider<Coffee> coffeeObjectProvider) {
//        return new CoffeeShop(coffeeObjectProvider);
//    }

    @Bean
    public IngredientFactoryBean sugar() {
        return new IngredientFactoryBean("sugar");
    }

    @Bean
    public IngredientFactoryBean milk() {
        return new IngredientFactoryBean("milk");
    }
}
