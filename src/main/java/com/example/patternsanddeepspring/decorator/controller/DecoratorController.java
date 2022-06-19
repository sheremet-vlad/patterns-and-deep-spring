package com.example.patternsanddeepspring.decorator.controller;

import com.example.patternsanddeepspring.decorator.entity.HtmlEncodedMessageDecorator;
import com.example.patternsanddeepspring.decorator.entity.Message;
import com.example.patternsanddeepspring.decorator.entity.TextMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecoratorController
{

   @GetMapping("/decorator")
   public String factoryMethod() throws CloneNotSupportedException
   {
      final Message decorator = new HtmlEncodedMessageDecorator(
               new TextMessage("<div> escaped text in decorator</b>"));
      return decorator.getContent();
   }
}

