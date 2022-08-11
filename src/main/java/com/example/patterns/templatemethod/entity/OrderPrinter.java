package com.example.patterns.templatemethod.entity;

import org.springframework.stereotype.Service;

//Abstract base class defines the template method
@Service
public abstract class OrderPrinter {

   public final void printOrder(final Order order)
   {
      System.out.println(start());

      System.out.println(formatOrderNumber(order));

      System.out.println(formatItems(order));

      System.out.println(formatTotal(order));

      System.out.println(end());
   }

   protected abstract String start();

   protected abstract String formatOrderNumber(Order order);

   protected abstract String formatItems(Order order);

   protected abstract String formatTotal(Order order);

   protected abstract String end();
}
