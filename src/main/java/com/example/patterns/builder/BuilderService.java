package com.example.patterns.builder;

import com.example.patterns.builder.entity.User;
import com.example.patterns.builder.entity.UserDTO;

public interface BuilderService
{
   UserDTO buildUserDTO(final User user);
}
