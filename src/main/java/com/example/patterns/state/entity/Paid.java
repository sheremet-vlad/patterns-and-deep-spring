package com.example.patterns.state.entity;

public class Paid implements OrderState {
   @Override
   public double handleCancellation()
   {
      System.out.println("customer will pay commission 5$");
      return 5;
   }
}
