package com.example.spring.strategy.impl;

import com.example.spring.annotation.Profiling;
import com.example.spring.entity.Shelter;
import com.example.spring.form.AddingPetToShelterForm;
import com.example.spring.service.PetService;
import com.example.spring.service.ShelterService;
import com.example.spring.strategy.AddingPetsToShelterStrategy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Profile("!prod")
@Profiling
public class FreeAddingPetsToShelterStrategy implements AddingPetsToShelterStrategy
{
   @Resource
   private PetService petService;

   @Resource
   private ShelterService shelterService;

   @Override
   public boolean addPetsToShelter(List<AddingPetToShelterForm> addingPetToShelterFormList,
            int shelterId)
   {
      final Shelter shelter = shelterService.findShelter(shelterId);

      final boolean result = petService.save(addingPetToShelterFormList, shelter);

      if (result)
      {
         shelter.setCountOfSavedPets(addingPetToShelterFormList.size());

      }

      return result;
   }
}
