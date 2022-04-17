package com.example.patternsanddeepspring.builder.entity;

import java.time.LocalDate;
import java.time.Period;

public class UserDTO
{
   private String firstName;
   private String lastName;
   private String age;
   private String city;

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public String getAge()
   {
      return age;
   }

   public void setAge(String age)
   {
      this.age = age;
   }

   public String getCity()
   {
      return city;
   }

   public void setCity(String city)
   {
      this.city = city;
   }

   public static Builder getBuilder() {
      return new Builder();
   }

   public static class Builder
   {
      private String firstName;
      private String lastName;
      private String age;
      private String city;
      private UserDTO userDTO;

      public Builder withFirstName(final String firstName)
      {
         this.firstName = firstName;
         return this;
      }

      public Builder withLastName(final String lastName)
      {
         this.lastName = lastName;
         return this;
      }

      public Builder withAge(final LocalDate localDate)
      {
         this.age = String.valueOf(Period.between(localDate, LocalDate.now()).getYears());
         return this;
      }

      public Builder withCity(final Address address)
      {
         this.city = address.getCity();
         return this;
      }

      public UserDTO build()
      {
         if (firstName == null || lastName == null)
         {
            throw new IllegalArgumentException("Not all mandatory fields are initialized");
         }
         userDTO = new UserDTO();
         userDTO.setFirstName(firstName);
         userDTO.setLastName(lastName);
         userDTO.setAge(age);
         userDTO.setCity(city);

         return userDTO;
      }
   }
}
