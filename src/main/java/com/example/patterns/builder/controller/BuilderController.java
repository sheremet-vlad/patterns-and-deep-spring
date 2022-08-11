package com.example.patterns.builder.controller;

import com.example.patterns.builder.BuilderService;
import com.example.patterns.builder.entity.User;
import com.example.patterns.builder.entity.UserDTO;
import com.example.patterns.util.Utils;
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
      final User user = Utils.createUser();
      return builderService.buildUserDTO(user);
   }
}
