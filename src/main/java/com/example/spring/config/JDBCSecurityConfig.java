package com.example.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;

@EnableWebSecurity
@Profile("prod")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JDBCSecurityConfig extends WebSecurityConfigurerAdapter
{
   @Resource
   private DataSource dataSource;

   @Bean
   public PasswordEncoder passwordEncoder()
   {
      return NoOpPasswordEncoder.getInstance();
   }

   @Override
   public void configure(AuthenticationManagerBuilder auth) throws Exception
   {
      auth.jdbcAuthentication()
               .dataSource(dataSource)
               .usersByUsernameQuery("SELECT login, password, 'true'  FROM user WHERE login = ?")
               .authoritiesByUsernameQuery("SELECT login, role from user where login = ?");
   }
}
