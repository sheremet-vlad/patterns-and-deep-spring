package com.example.spring.controller;

import com.example.spring.entity.Pet;
import com.example.spring.entity.Shelter;
import com.example.spring.form.AddingPetToShelterForm;
import com.example.spring.form.AddingShelterForm;
import com.example.spring.service.ShelterService;
import com.example.spring.strategy.AddingPetsToShelterStrategy;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/shelters")

public class ShelterController
{
   @Resource
   private ShelterService shelterService;

   @Resource
   private AddingPetsToShelterStrategy strategy;

   @Resource
   private CacheManager cacheManager;

   @GetMapping
   public List<Shelter> getShelters()
   {
      return shelterService.getAllShelters();
   }

   @PostMapping("/add")
   public ResponseEntity<Shelter> createShelter(
            @RequestBody final AddingShelterForm addingShelterForm)
   {
      final Shelter shelter = shelterService.saveShelter(addingShelterForm);

      return Objects.nonNull(shelter) ? new ResponseEntity<>(shelter, HttpStatus.CREATED) :
               new ResponseEntity<>(HttpStatus.BAD_REQUEST);
   }

   @PostMapping("/{shelterId}/pets/add")
   @PreAuthorize("hasAnyAuthority('ADMIN') || hasAnyRole('ADMIN')")
   public ResponseEntity<Pet> addPetsToShelter(@PathVariable int shelterId,
            @RequestBody final List<AddingPetToShelterForm> addingPetToShelterForms)
   {
      boolean result = strategy.addPetsToShelter(addingPetToShelterForms, shelterId);

      return new ResponseEntity<>(result ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
   }
}
