package com.example.patterns.facade.controller;

import com.example.patterns.facade.EmailFacade;
import com.example.patterns.facade.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FacadeController
{
   @Resource
   private EmailFacade emailFacade;

   @GetMapping("/facade")
   public String getFacadePatternExample()
   {
      final Order order = new Order("101", 99.99);

      boolean result = emailFacade.sendOrderEmailWithoutFacade(order);

      return "Order Email " + (result ? "sent!" : "NOT sent...");
   }
}

