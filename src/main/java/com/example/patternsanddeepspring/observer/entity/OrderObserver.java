package com.example.patternsanddeepspring.observer.entity;

//Abstract observer
public interface OrderObserver {

    void updated(Order order);
}
