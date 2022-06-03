package com.example.patternsanddeepspring.state.controller;

import com.example.patternsanddeepspring.state.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController
{
   @GetMapping("/state")
   public String factoryMethod() throws CloneNotSupportedException
   {
      final Order order = new Order();
      order.paymentSuccessful();
      order.cancel();

      return "state result printed to console";
   }
}

