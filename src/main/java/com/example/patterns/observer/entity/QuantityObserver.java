package com.example.patterns.observer.entity;

public class QuantityObserver implements OrderObserver {

    @Override
    public void updated(Order order) {
        int count = order.getCount();
        if(count <= 5) {
            System.out.println("delivery - 10");
        } else {
            System.out.println("delivery -5");
        }
    }
}
