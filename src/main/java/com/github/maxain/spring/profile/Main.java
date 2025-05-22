package com.github.maxain.spring.profile;

import com.github.maxain.spring.profile.beans.CoffeeShop;
import com.github.maxain.spring.profile.beans.Holder;
import com.github.maxain.spring.profile.beans.LazyBean;
import com.github.maxain.spring.profile.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        CoffeeShop coffeeShop = context.getBean(CoffeeShop.class);
        coffeeShop.orderCoffee();
        coffeeShop.printShopName();

        Holder holder = context.getBean(Holder.class);
        holder.fireLazyBean();

        LazyBean lazyBean = context.getBean(LazyBean.class);
        lazyBean.fireHolderBean();
    }
}
