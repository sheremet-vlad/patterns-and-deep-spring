package com.example.spring.service;

import com.example.spring.entity.Shelter;
import com.example.spring.form.AddingShelterForm;

import java.util.List;

public interface ShelterService
{
   List<Shelter> getAllShelters();

   Shelter findShelter(final int id);

   Shelter saveShelter(final AddingShelterForm form);
}
