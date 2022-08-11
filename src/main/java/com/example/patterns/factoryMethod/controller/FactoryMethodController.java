package com.example.patterns.factoryMethod.controller;

import com.example.patterns.factoryMethod.JSONMessageCreator;
import com.example.patterns.factoryMethod.TextMessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactoryMethodController
{
   @GetMapping("/factoryMethod")
   public String factoryMethod()
   {
      final StringBuilder builder = new StringBuilder();

      builder.append("build via factory method").append("\n");
      builder.append("json message: ").append(new JSONMessageCreator().getMessage()).append("\n");
      builder.append("text message: ").append(new TextMessageCreator().getMessage()).append("\n");

      return builder.toString();
   }
}

