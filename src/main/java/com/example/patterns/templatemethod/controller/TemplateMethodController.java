package com.example.patterns.templatemethod.controller;

import com.example.patterns.templatemethod.entity.Order;
import com.example.patterns.templatemethod.entity.OrderPrinter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TemplateMethodController
{
   @Resource(name = "textPrinter")
   private OrderPrinter orderPrinter;

   @GetMapping("/templateMethod")
   public String templateMethod()
   {
      final Order o = new Order("100");
      o.addItem("Soda", 2);
      o.addItem("Chips", 10);

      orderPrinter.printOrder(o);

      return "result template pattern printed to console";
   }
}

