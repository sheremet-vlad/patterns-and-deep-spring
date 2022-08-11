package com.example.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Veterinarian
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(nullable = false)
   private String fullName;

   @Enumerated(EnumType.STRING)
   private Specialization specialization;

   @ManyToOne
   @JoinColumn(name = "shelter_id")
   private Shelter shelter;

   @OneToMany(mappedBy = "veterinarian")
   private Set<Pet> veterinarianPets;

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

   public Specialization getSpecialization()
   {
      return specialization;
   }

   public void setSpecialization(Specialization specialization)
   {
      this.specialization = specialization;
   }

   public Shelter getShelter()
   {
      return shelter;
   }

   public void setShelter(Shelter shelter)
   {
      this.shelter = shelter;
   }

   public Set<Pet> getVeterinarianPets()
   {
      return veterinarianPets;
   }

   public void setVeterinarianPets(Set<Pet> veterinarianPets)
   {
      this.veterinarianPets = veterinarianPets;
   }
}
