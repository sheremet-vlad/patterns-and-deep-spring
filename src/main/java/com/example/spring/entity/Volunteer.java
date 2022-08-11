package com.example.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Volunteer
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(nullable = false)
   private String fullName;

   @ManyToMany(mappedBy = "shelterVolunteers")
   private Set<Shelter> shelters;

   @OneToMany(mappedBy = "volunteer")
   private Set<Pet> volunteerPets;

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getFullName()
   {
      return fullName;
   }

   public void setFullName(String fullName)
   {
      this.fullName = fullName;
   }

   public Set<Shelter> getShelters()
   {
      return shelters;
   }

   public void setShelters(Set<Shelter> shelters)
   {
      this.shelters = shelters;
   }

   public Set<Pet> getVolunteerPets()
   {
      return volunteerPets;
   }

   public void setVolunteerPets(Set<Pet> volunteerPets)
   {
      this.volunteerPets = volunteerPets;
   }
}
