package com.example.patternsanddeepspring.builder.controller;

import com.example.patternsanddeepspring.builder.BuilderService;
import com.example.patternsanddeepspring.builder.entity.User;
import com.example.patternsanddeepspring.builder.entity.UserDTO;
import com.example.patternsanddeepspring.util.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BuilderController
{
   @Resource
   private BuilderService builderService;

   @GetMapping("/builder")
   public UserDTO test()
   {
      //it's not a builder it's factory method
      final User user = Utils.createUser();
      return builderService.buildUserDTO(user);
   }
}
