package com.github.maxain.spring.scope;

import com.github.maxain.spring.scope.beans.HeadChef;
import com.github.maxain.spring.scope.beans.ObjectProviderExample;
import com.github.maxain.spring.scope.beans.OrderProcessor;
import com.github.maxain.spring.scope.beans.Waiter;
import com.github.maxain.spring.scope.config.RestaurantConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;

public class RestaurantApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RestaurantConfig.class);

        HeadChef first = context.getBean(HeadChef.class);
        HeadChef second = context.getBean(HeadChef.class);
        first.setName("Max");
        System.out.println(first);
        System.out.println(second);

        Waiter firstWaiter = context.getBean(Waiter.class, UUID.randomUUID());
        Waiter secondWaiter = context.getBean(Waiter.class, UUID.randomUUID());
        firstWaiter.setOrder("Coffee");
        System.out.println(firstWaiter);
        System.out.println(secondWaiter);

        // With object provider
        ObjectProviderExample objectProviderExample = context.getBean(ObjectProviderExample.class);
        objectProviderExample.getAndCompareHeadChef();
        objectProviderExample.getAndCompareWaiter();

        OrderProcessor processor = context.getBean(OrderProcessor.class);
        processor.processOrder("Coffee", 9);
    }
}
