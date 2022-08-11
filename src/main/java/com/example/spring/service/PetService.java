package com.example.spring.service;

import com.example.spring.entity.Pet;
import com.example.spring.entity.Shelter;
import com.example.spring.form.AddingPetToShelterForm;

import java.util.List;

public interface PetService
{
   boolean save(final List<AddingPetToShelterForm> petForms, final Shelter shelter);

   List<Pet> getAllPets();
}
