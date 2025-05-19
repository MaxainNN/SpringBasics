package com.github.maxain.spring.postprocessor.processor;

import com.github.maxain.spring.postprocessor.annotation.Discount;
import com.github.maxain.spring.postprocessor.beans.Food;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Класс DiscountableBeanPostProcessor является BeanPostProcessor в Spring,
 * который модифицирует бины перед их инициализацией, добавляя скидку к
 * определенным продуктам (если они соответствуют условиям).
 * BeanPostProcessor позволяет вмешиваться в процесс создания бинов.
 */
@Component
public class DiscountableBeanPostProcessor implements BeanPostProcessor {

    /**
     * postProcessBeforeInitialization вызывается после создания бина,
     * но до его инициализации (до @PostConstruct, InitializingBean.afterPropertiesSet()
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        // Если бин является объектом класса Food (или его подкласса), то выполняется дальнейшая логика.
        if (bean instanceof Food food){
            Class<Food> foodClass = (Class<Food>) bean.getClass();

            try {
                // Получает поле discount у класса Food через рефлексию кода
                Field discountField = foodClass.getDeclaredField("discount");
                // Если поле помечено аннотацией @Discount и тип продукта — "Pasta", то применяется скидка.
                if (discountField.isAnnotationPresent(Discount.class) && food.getType().equals("Pasta")){
                    Discount discount = discountField.getAnnotation(Discount.class);
                    // Берем значение percent() из аннотации @Discount и устанавливаем его в поле discount объекта Food
                    food.setDiscount(discount.percent());
                }
            } catch (NoSuchFieldException e){
                throw new RuntimeException(e);
            }
        }
        return bean;
    }
}
