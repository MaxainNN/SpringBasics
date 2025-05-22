package com.github.maxain.spring.profile.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("latte")
//@Primary
public class Latte implements Coffee{
    @Override
    public String brew() {
        return "Latte";
    }
}
