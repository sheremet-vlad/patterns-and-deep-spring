package com.example.spring.strategy;

import com.example.spring.form.AddingPetToShelterForm;

import java.util.List;

public interface AddingPetsToShelterStrategy
{
   boolean addPetsToShelter(final List<AddingPetToShelterForm> addingPetToShelterFormList,
            final int shelterId);
}
