package com.example.patternsanddeepspring.strategy.entity;

import java.util.Collection;

//Strategy
public interface OrderPrinter {
   void print(Collection<Order> orders);
}
