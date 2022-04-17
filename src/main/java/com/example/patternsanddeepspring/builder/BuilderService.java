package com.example.patternsanddeepspring.builder;

import com.example.patternsanddeepspring.builder.entity.User;
import com.example.patternsanddeepspring.builder.entity.UserDTO;

public interface BuilderService
{
   UserDTO buildUserDTO(final User user);
}
