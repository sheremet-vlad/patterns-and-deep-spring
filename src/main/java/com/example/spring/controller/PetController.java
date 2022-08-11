package com.example.spring.controller;

import com.example.spring.entity.Pet;
import com.example.spring.service.PetService;
import com.example.spring.service.ProcedureService;
import com.example.spring.service.ShelterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController
{
   @Resource
   private ShelterService shelterService;

   @Resource
   private ProcedureService procedureService;

   @Resource
   private PetService petService;

   @GetMapping
   @Secured("USER")
   public List<Pet> getPets()
   {
      return petService.getAllPets();
   }

   @GetMapping("/{petId}/commonInspection")
   public ResponseEntity<Boolean> makeCommonProcedure(@PathVariable int petId)
   {
      return procedureService.commonInspection(petId) ? new ResponseEntity<>(HttpStatus.OK)
               : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
   }
}
