package com.example.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Profile("dev")
public class InMemorySecurityConfig extends WebSecurityConfigurerAdapter
{

   @Bean
   public PasswordEncoder passwordEncoder()
   {
      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
   }

   @Override
   public void configure(AuthenticationManagerBuilder auth) throws Exception
   {
      auth.inMemoryAuthentication()
               .withUser("user")
               .password("{noop}nimda")
               .authorities("ROLE_USER")
               .and()
               .withUser("admin")
               .password("{noop}nimda")
               .authorities("ROLE_ADMIN", "ROLE_USER");
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception
   {
      http.authorizeRequests()
               .antMatchers("/shelters/add/**").hasAnyRole("ADMIN")
               .antMatchers("/**").permitAll()
               .and()
               .formLogin();
   }
}
