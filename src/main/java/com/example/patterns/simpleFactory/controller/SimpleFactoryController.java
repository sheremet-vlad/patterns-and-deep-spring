package com.example.patterns.simpleFactory.controller;

import com.example.patterns.simpleFactory.PostFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleFactoryController
{
   @GetMapping("/simpleFactory")
   public String test()
   {
      final StringBuilder builder = new StringBuilder();
      builder.append("build via simple factory ").append("\n");
      builder.append("blog: ").append(PostFactory.createInstance("blog")).append("\n");
      builder.append("news: ").append(PostFactory.createInstance("news")).append("\n");
      builder.append("product: ").append(PostFactory.createInstance("product")).append("\n");

      return builder.toString();
   }
}

