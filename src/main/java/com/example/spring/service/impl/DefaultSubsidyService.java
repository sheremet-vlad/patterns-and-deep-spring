package com.example.spring.service.impl;

import com.example.spring.entity.Pet;
import com.example.spring.service.SubsidyService;
import org.springframework.stereotype.Service;

@Service
public class DefaultSubsidyService implements SubsidyService
{
   @Override
   public Double calculateSubsidy(Pet pet)
   {
      return null;
   }
}
