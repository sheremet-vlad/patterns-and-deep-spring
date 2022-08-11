package com.example.patterns.observer.entity;

//Concrete observer
public class PriceObserver implements OrderObserver {
   @Override
   public void updated(Order order)
   {
      if (order.getItemCost() >= 100) {
         System.out.println("wow, we have a good order");
      }
   }
}
