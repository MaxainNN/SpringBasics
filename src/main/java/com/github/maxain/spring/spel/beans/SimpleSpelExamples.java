package com.github.maxain.spring.spel.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SimpleSpelExamples {

    @Value("#{4 + 2}")
    private int numEval;

    @Value("#{'I am a '.concat('string')}")
    private String strEval;

    @Value("#{2 > 3 and 1 < 10}")
    private boolean boolEval;

    @Value("#{1 != 1 ? 0 : 1}")
    private int ternary;

    @Value("#{'${my.prop}' ?: 'defaultValue'}")
    private String defaultValue;

    @Value("${app.os.name}")
    private String osName;

    public void simpleEval() {
        System.out.println("Number: " + numEval);
        System.out.println("String: " + strEval);
        System.out.println("Boolean: " + boolEval);
        System.out.println("Ternary: " + ternary);
        System.out.println("Default value: " + defaultValue);
        System.out.println("OS Name: " + osName);
    }

    public void simpleEvaluateContextExample() {
        simpleReadonlyContext();
        System.out.println("---------");
        simpleReadyWriteContext();
    }

    private void simpleReadonlyContext() {
        SpelExpressionParser parser = new SpelExpressionParser();

        // Создаем объект для разбора (содержит список и карту)
        ExpressionParserObject object = new ExpressionParserObject();

        // Создаем контекст оценки только для чтения
        EvaluationContext readonlyContext = SimpleEvaluationContext.forReadOnlyDataBinding().build();

        // Парсим выражение для получения первого элемента списка
        Expression firstStrValueExpression = parser.parseExpression("strValues[0]");
        String firstFromList = firstStrValueExpression.getValue(readonlyContext, object, String.class);

        System.out.println("First from list: " + firstFromList);

        // Парсим выражение для получения значения из map по ключу 2
        Expression secondFromMap = parser.parseExpression("keyValue[2]");
        // Устанавливаем новое значение и выводим map
        System.out.println("Second from map: " + secondFromMap.getValue(readonlyContext, object, String.class));
    }

    private void simpleReadyWriteContext() {
        SpelExpressionParser parser = new SpelExpressionParser();
        ExpressionParserObject object = new ExpressionParserObject();
        // Создаем контекст оценки для чтения/записи
        EvaluationContext context = SimpleEvaluationContext.forReadWriteDataBinding().build();

        Expression getListExp = parser.parseExpression("strValues");
        List<String> values = getListExp.getValue(context, object, List.class);
        values.add("four");

        System.out.println("Object list: " + object.getStrValues());

        // Парсим выражение для изменения значения в map по ключу 1
        Expression changeFirstValueExp = parser.parseExpression("keyValue[1]");
        changeFirstValueExp.setValue(context, object, "new one");

        System.out.println("Object map: " + object.getKeyValue());
    }

    /**
     * Вложенный класс с тестовыми данными типа List и Map
     */
    private static class ExpressionParserObject {
        private List<String> strValues = new ArrayList<>(List.of("one", "two", "three"));
        private Map<Integer, String> keyValue = new HashMap<>(Map.of(
                1, "one", 2, "two", 3, "three"));

        public List<String> getStrValues() {
            return strValues;
        }

        public Map<Integer, String> getKeyValue() {
            return keyValue;
        }
    }
}
