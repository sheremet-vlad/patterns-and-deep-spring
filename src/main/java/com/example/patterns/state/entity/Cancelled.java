package com.example.patterns.state.entity;

public class Cancelled implements OrderState {
   @Override
   public double handleCancellation()
   {
      throw new IllegalArgumentException("Order already cancelled");
   }
}
