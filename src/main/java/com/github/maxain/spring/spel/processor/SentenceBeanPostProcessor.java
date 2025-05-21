package com.github.maxain.spring.spel.processor;

import com.github.maxain.spring.spel.annotation.Sentence;
import com.github.maxain.spring.spel.beans.Customer;
import com.github.maxain.spring.spel.beans.Waiter;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Класс представляет собой реализацию BeanPostProcessor, который выполняет
 * обработку бинов на этапе их инициализации, используя Spring Expression Language (SpEL)
 */
@Component
public class SentenceBeanPostProcessor implements BeanPostProcessor {

    private static final String SET_GREETING_MESSAGE_METHOD = "setGreetingMessage";
    private static final String SET_STATIC_GREETING_MESSAGE_METHOD = "setStaticGreetingMessage";
    private static final String GREETING_FIELD = "greeting";
    private static final String BEAN_VARIABLE = "bean";

    // Парсер для разбора SpEL выражений
    private final SpelExpressionParser parser = new SpelExpressionParser();

    // Контекст для выполнения SpEL выражений
    private final StandardEvaluationContext evaluationContext = new StandardEvaluationContext();

    // Корневой объект для SpEL выражений
    private final SentenceRootObject rootObject = new SentenceRootObject();

    @PostConstruct //  Метод выполняется после создания бина и инъекции зависимостей
    public void configureContext() {
        // Устанавливаем корневой объект для контекста оценки
        evaluationContext.setRootObject(rootObject);
        // Регистрируем метод setGreetingMessage из rootObject как функцию в SpEL
        evaluationContext.registerFunction(SET_GREETING_MESSAGE_METHOD, getMethod(rootObject,
                SET_GREETING_MESSAGE_METHOD, Object.class));
        // Регистрируем статический метод setStaticGreetingMessage как функцию в SpEL
        evaluationContext.registerFunction(SET_STATIC_GREETING_MESSAGE_METHOD,
                getStaticMethod(SentenceRootObject.class, SET_STATIC_GREETING_MESSAGE_METHOD, Object.class));
    }

    /**
     * Вызывается Spring'ом перед инициализацией каждого бина
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass() == Waiter.class || bean.getClass() == Customer.class) {
            // Устанавливаем текущий бин как переменную bean в контексте оценки
            evaluationContext.setVariable(BEAN_VARIABLE, bean);

            try {
                // Находим поле greeting в классе бина
                Field field = bean.getClass().getDeclaredField(GREETING_FIELD);
                // Получаем аннотацию @Sentence у этого поля
                Sentence sentence = field.getAnnotation(Sentence.class);

                // Разбираем и выполняем SpEL выражение из аннотации @Sentence
                parser.parseExpression(sentence.expression()).getValue(evaluationContext);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }

        // Возвращаем обработанный бин
        return bean;
    }

    /**
     * Получение метода объекта по имени и параметрам из объекта
     */
    private Method getMethod(Object obj, String name, Class<?>... args) {
        try {
            return obj.getClass().getDeclaredMethod(name, args);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Получение статического метода по имени и параметрам из класса
     */
    private Method getStaticMethod(Class<?> type, String name, Class<?>... args) {
        try {
            return type.getDeclaredMethod(name, args);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
