package com.example.patternsanddeepspring.nullobject.controller;

import com.example.patternsanddeepspring.nullobject.entity.ComplexService;
import com.example.patternsanddeepspring.nullobject.entity.NullStorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class NullObjectController
{
   @Resource
   private NullStorageService nullStorageService;

   @GetMapping("/nullObject")
   public String nullObject()
   {
      ComplexService service = new ComplexService("Simple report 2", nullStorageService);
      service.generateReport();

      return "result printed to the console";
   }
}

