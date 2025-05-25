package com.github.maxain.spring.proxy.process;

import com.github.maxain.spring.proxy.beans.IWaiter;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Semaphore;

/**
 * Реализация BeanPostProcessor , котроая ограничивает количество
 * одновременных вызовов методов для бинов, реализующих интерфейс IWaiter
 */
@Component
public class ConcurrentCallsLimiterBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        Class<?> beanClass = bean.getClass();

        if (bean instanceof IWaiter) {
            /**
             * Если бин реализует IWaiter, то вместо него возвращается прокси-объект, который оборачивает исходный бин.
             */
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                /**
                 * Внутри прокси используется Semaphore с 2 разрешениями , что означает:
                 * Одновременно могут выполняться не более 2 вызовов методов
                 */
                private final Semaphore semaphore = new Semaphore(2);

                /**
                 * При вызове любого метода (invoke):
                 * Поток запрашивает разрешение у семафора (semaphore.acquire()).
                 * Если свободных разрешений нет, поток блокируется, пока одно не освободится.
                 * После получения разрешения вызывается исходный метод (method.invoke(bean, args)).
                 * Перед захватом семафора выводится количество доступных разрешений (semaphore.availablePermits())
                 */
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    try {
                        System.out.println("Acquire..." + semaphore.availablePermits());
                        semaphore.acquire();
                        return method.invoke(bean, args);
                    } finally {
                        semaphore.release();
                        System.out.println("Release...");
                    }
                }
            });
        }

        return bean;
    }
}
