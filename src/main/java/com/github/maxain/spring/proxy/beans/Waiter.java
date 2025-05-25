package com.github.maxain.spring.proxy.beans;

public class Waiter implements IWaiter{

    private final String name;

    public Waiter(String name) {
        this.name = name;
    }

    @Override
    public void serve(String customerName) {
        System.out.println(name + " is serving customer " + customerName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " is free");
    }
}
