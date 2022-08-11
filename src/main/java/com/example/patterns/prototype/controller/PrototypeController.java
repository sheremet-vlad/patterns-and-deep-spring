package com.example.patterns.prototype.controller;

import com.example.patterns.prototype.entity.Swordsman;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrototypeController
{
   @GetMapping("/prototype")
   public String factoryMethod() throws CloneNotSupportedException
   {
      final Swordsman swordsman = new Swordsman();
      swordsman.setCount(4);

      final Swordsman swordsman2 = (Swordsman) swordsman.clone();

      final StringBuilder builder = new StringBuilder();
      builder.append("Swordsman 1: ").append(swordsman);
      builder.append(" Swordsman:1 ").append(swordsman2);

      return builder.toString();
   }
}

