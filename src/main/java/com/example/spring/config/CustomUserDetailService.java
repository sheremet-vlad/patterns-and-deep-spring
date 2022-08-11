package com.example.spring.config;

import com.example.spring.dao.UserRepository;
import com.example.spring.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class CustomUserDetailService implements UserDetailsService
{
   @Resource
   private UserRepository userRepository;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
   {
      final User user = userRepository.findByLogin(username);

      if (Objects.isNull(user))
      {
         throw new UsernameNotFoundException("Unknown user: " + username);
      }

      return org.springframework.security.core.userdetails.User.builder()
               .username(username)
               .password(user.getPassword())
               .roles(user.getRole())
               .build();
   }

}
