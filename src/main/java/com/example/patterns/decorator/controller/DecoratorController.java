package com.example.patterns.decorator.controller;

import com.example.patterns.decorator.entity.HtmlEncodedMessage;
import com.example.patterns.decorator.entity.Message;
import com.example.patterns.decorator.entity.TextMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecoratorController
{

   @GetMapping("/decorator")
   public String factoryMethod() throws CloneNotSupportedException
   {
      final Message decorator = new HtmlEncodedMessage(
               new TextMessage("<div> escaped text in decorator</b>"));
      return decorator.getContent();
   }
}

