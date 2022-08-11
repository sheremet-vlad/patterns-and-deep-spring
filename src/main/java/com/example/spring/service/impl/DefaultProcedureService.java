package com.example.spring.service.impl;

import com.example.spring.annotation.Profiling;
import com.example.spring.dao.PetRepository;
import com.example.spring.entity.Shelter;
import com.example.spring.service.ProcedureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;

@Service
@Profiling
public class DefaultProcedureService implements ProcedureService
{
   private static final Logger LOGGER = LoggerFactory.getLogger(DefaultProcedureService.class);

   private static final String BASE_URL = "http://localhost:8080/shelters";

   @Resource
   private PetRepository petRepository;

   @Override
   public boolean commonInspection(final int petId)
   {
      Flux<Shelter> shelters = WebClient.builder()
               .baseUrl(BASE_URL)
               .build()
               .get()
               .retrieve()
               .bodyToFlux(Shelter.class);

      final String name = petRepository.getById(petId).getName();

      shelters.subscribe(shelter ->
               LOGGER.info("make a common inspection for pet {} in shelter {}", name, shelter));

      return true;
   }
}
