package com.example.patternsanddeepspring.templatemethod.entity;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TextPrinter extends OrderPrinter {
   @Override
   protected String start()
   {
      return "Order details";
   }

   @Override
   protected String formatOrderNumber(Order order)
   {
      return "Order number:" + order.getId();
   }

   @Override
   protected String formatItems(Order order)
   {
      return order.getItems()
               .entrySet()
               .stream()
               .map(entry -> entry.getKey() + ":" + entry.getValue())
               .collect(Collectors.joining(", "));
   }

   @Override
   protected String formatTotal(Order order)
   {
      return "total: " + order.getTotal();
   }

   @Override
   protected String end()
   {
      return ".";
   }
}
