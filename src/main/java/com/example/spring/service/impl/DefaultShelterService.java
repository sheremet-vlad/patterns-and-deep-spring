package com.example.spring.service.impl;

import com.example.spring.dao.ShelterRepository;
import com.example.spring.entity.Shelter;
import com.example.spring.form.AddingShelterForm;
import com.example.spring.service.ShelterService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class DefaultShelterService implements ShelterService
{
   @Resource
   private ShelterRepository shelterRepository;

   @Override
   @Cacheable(value = "shelters")
   public List<Shelter> getAllShelters()
   {
      return shelterRepository.findAll();
   }

   @Override
   public Shelter findShelter(int id)
   {
      return shelterRepository.getById(id);
   }

   @Override
   @Transactional
   @CacheEvict("shelters")
   public Shelter saveShelter(final AddingShelterForm form)
   {
      return Objects.nonNull(form) ? shelterRepository.save(createShelter(form)) : null;
   }

   private Shelter createShelter(final AddingShelterForm form)
   {
      final Shelter shelter = new Shelter();
      shelter.setName(form.getName());

      return shelter;
   }
}
