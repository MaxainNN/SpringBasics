package com.github.maxain.spring.lifecycle.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Для Java 8
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Coffee {

    private final String type;

    public Coffee(String type){
        this.type = type;
    }

    /**
     * Вызывается после создания бина и внедрения зависимостей (@Autowired).
     */
    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct -> make coffee with type: " + type);
    }

    /**
     * Вызывается перед уничтожением бина (при закрытии контекста Spring).
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy -> before destroy proxy");
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type='" + type + '\'' +
                '}';
    }
}
