package com.example.patternsanddeepspring.decorator.controller;

import com.example.patternsanddeepspring.decorator.entity.HtmlEncodedMessage;
import com.example.patternsanddeepspring.decorator.entity.Message;
import com.example.patternsanddeepspring.decorator.entity.TextMessage;
import com.example.patternsanddeepspring.objectPool.ObjectPool;
import com.example.patternsanddeepspring.objectPool.entity.Image;
import com.example.patternsanddeepspring.objectPool.entity.PngImage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

