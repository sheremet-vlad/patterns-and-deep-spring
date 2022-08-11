package com.example.patterns.builder.impl;

import com.example.patterns.builder.BuilderService;
import com.example.patterns.builder.entity.User;
import com.example.patterns.builder.entity.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class DefaultBuilderService implements BuilderService
{
   @Override
   public UserDTO buildUserDTO(final User user)
   {
      return UserDTO.getBuilder().withFirstName(user.getFirstName()).withLastName(user.getLastName())
               .withCity(user.getAddress())
               .withAge(user.getBirthday())
               .build();
   }
}
