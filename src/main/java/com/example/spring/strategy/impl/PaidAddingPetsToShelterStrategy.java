package com.example.spring.strategy.impl;

import com.example.spring.entity.Shelter;
import com.example.spring.form.AddingPetToShelterForm;
import com.example.spring.generators.Generator;
import com.example.spring.service.PetService;
import com.example.spring.service.ShelterService;
import com.example.spring.strategy.AddingPetsToShelterStrategy;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Profile("prod")
public class PaidAddingPetsToShelterStrategy implements AddingPetsToShelterStrategy
{
   @Resource
   private PetService petService;

   @Resource
   private ShelterService shelterService;

   @Override
   @Transactional
   public boolean addPetsToShelter(List<AddingPetToShelterForm> addingPetToShelterFormList,
            int shelterId)
   {
      final Shelter shelter = shelterService.findShelter(shelterId);

      final boolean result = petService.save(addingPetToShelterFormList, shelter);

      if (result)
      {
         shelter.setCountOfSavedPets(addingPetToShelterFormList.size());
         shelter.setSubsidiesSum(shelter.getSubsidiesSum() +
                  calculateSubsidy(addingPetToShelterFormList));
      }

      return result;
   }

   private Double calculateSubsidy(final List<AddingPetToShelterForm> addingPetToShelterForms)
   {
      return addingPetToShelterForms.stream()
               .mapToDouble(form -> getGenerator().generate(form.getAge()))
               .sum();
   }

   @Lookup
   public Generator getGenerator()
   {
      return null;
   }
}
