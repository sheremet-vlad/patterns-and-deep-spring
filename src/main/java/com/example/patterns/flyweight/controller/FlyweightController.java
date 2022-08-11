package com.example.patterns.flyweight.controller;

import com.example.patterns.flyweight.entity.ErrorMessageFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FlyweightController
{
   @Resource
   private ErrorMessageFactory errorMessageFactory;

   @GetMapping("/flyweight")
   public String flyweightMethod()
   {
      final StringBuilder builder = new StringBuilder();

      builder.append("flyweight pattern example: ")
               .append(errorMessageFactory
               .getErrorMessage(ErrorMessageFactory.ErrorType.ServerError).getText("500"));

      return builder.toString();
   }
}

