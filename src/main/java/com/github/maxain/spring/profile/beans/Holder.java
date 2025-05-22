package com.github.maxain.spring.profile.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Holder {
    private final LazyBean lazyBean;

    public Holder(@Lazy LazyBean lazyBean) {
        this.lazyBean = lazyBean;
    }

    @PostConstruct
    public void construct() {
        System.out.println("Holder bean constructed!");
    }

    public void fireLazyBean() {
        System.out.println("From holder bean: " + lazyBean.getInfo());
    }

    public String getInfo() {
        return "I'm holder bean";
    }
}
