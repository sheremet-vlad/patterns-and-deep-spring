package com.example.patternsanddeepspring.strategy.controller;

import com.example.patternsanddeepspring.strategy.entity.DetailPrinter;
import com.example.patternsanddeepspring.strategy.entity.Order;
import com.example.patternsanddeepspring.strategy.entity.PrintService;
import com.example.patternsanddeepspring.strategy.entity.SummaryPrinter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class StrategyController
{
   private LinkedList<Order> orders = new LinkedList<>();

   @GetMapping("/strategy")
   public String strategy()
   {
      createOrders();

      new PrintService(new DetailPrinter()).printOrders(orders);
      new PrintService(new SummaryPrinter()).printOrders(orders);

      return "result strategy pattern printed to console";
   }

   private void createOrders()
   {
      Order o = new Order("100");
      o.addItem("Soda", 2);
      o.addItem("Chips", 10);
      orders.add(o);

      o = new Order("200");
      o.addItem("Cake", 20);
      o.addItem("Cookies", 5);
      orders.add(o);

      o = new Order("300");
      o.addItem("Burger", 8);
      o.addItem("Fries", 5);
      orders.add(o);
   }
}

