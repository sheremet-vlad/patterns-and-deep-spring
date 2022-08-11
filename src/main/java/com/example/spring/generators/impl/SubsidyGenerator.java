package com.example.spring.generators.impl;

import com.example.spring.generators.Generator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@Service
@Scope(value = "prototype")
public class SubsidyGenerator implements Generator
{
   private Double value;

   @Override
   public double generate(final int age)
   {
      if (Objects.isNull(value))
      {
         value = new Random().nextDouble() * age;
      }

      return value;
   }
}
