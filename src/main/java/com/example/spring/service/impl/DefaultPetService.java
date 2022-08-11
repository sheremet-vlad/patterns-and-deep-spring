package com.example.spring.service.impl;

import com.example.spring.annotation.Profiling;
import com.example.spring.dao.PetRepository;
import com.example.spring.entity.Pet;
import com.example.spring.entity.Shelter;
import com.example.spring.form.AddingPetToShelterForm;
import com.example.spring.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@Profiling
public class DefaultPetService implements PetService
{
   private static final Logger LOGGER =
            LoggerFactory.getLogger(DefaultPetService.class);

   @Resource
   private PetRepository petRepository;

   @Override
   @Transactional
   @CacheEvict("pets")
   public boolean save(final List<AddingPetToShelterForm> petForms, final Shelter shelter)
   {
      if (CollectionUtils.isEmpty(petForms))
      {
         LOGGER.info("didn't save any pets, as list is empty");
         return false;

      }

      petForms.stream()
               .map(petForm -> createPet(petForm, shelter))
               .forEach(pet -> petRepository.save(pet));

      return true;
   }

   @Override
   @CachePut("pets")
   public List<Pet> getAllPets()
   {
      return petRepository.findAll();
   }

   private Pet createPet(final AddingPetToShelterForm petForm, final Shelter shelter)
   {
      final Pet pet = new Pet();
      pet.setName(petForm.getName());
      pet.setAge(petForm.getAge());
      pet.setPetShelter(shelter);

      return pet;
   }
}
