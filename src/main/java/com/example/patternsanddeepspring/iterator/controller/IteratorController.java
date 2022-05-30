package com.example.patternsanddeepspring.iterator.controller;

import com.example.patternsanddeepspring.interpreter.entity.ExpressionBuilder;
import com.example.patternsanddeepspring.interpreter.entity.PermissionExpression;
import com.example.patternsanddeepspring.interpreter.entity.Report;
import com.example.patternsanddeepspring.interpreter.entity.User;
import com.example.patternsanddeepspring.iterator.entity.Iterator;
import com.example.patternsanddeepspring.iterator.entity.ThemeColor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IteratorController
{
   @Resource
   private ExpressionBuilder builder;

   @GetMapping("/iterator")
   public String interpreter()
   {
      final Iterator<ThemeColor> colorIterator = ThemeColor.getIterator();

      final StringBuilder builder = new StringBuilder("Color cycled via iterator: ");
      while (colorIterator.hasNext())
      {
         builder.append(colorIterator.next()).append(", ");
      }

      return builder.toString();
   }
}

