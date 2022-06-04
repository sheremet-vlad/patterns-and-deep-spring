package com.example.patternsanddeepspring.strategy.entity;

import java.util.Collection;

//Concrete strategy
public class SummaryPrinter implements OrderPrinter {
   @Override
   public void print(Collection<Order> orders)
   {
      System.out.println("summary report");
      System.out.println("count of orders: " + orders.size());
   }
}
