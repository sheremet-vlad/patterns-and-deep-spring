package com.example.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Shelter
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(nullable = false)
   private String name;

   @ManyToMany
   @JoinTable(
            name = "shelter_has_veterinarian",
            joinColumns = @JoinColumn(name = "shelter_id"),
            inverseJoinColumns = @JoinColumn(name = "volunteer_id"))
   private Set<Volunteer> shelterVolunteers;

   @OneToMany(mappedBy = "shelter", fetch = FetchType.LAZY)
   private Set<Veterinarian> veterinarians;

   @OneToMany(mappedBy = "petShelter", fetch = FetchType.LAZY)
   @JsonIgnore
   private Set<Pet> pets;

   @Column
   private Double subsidiesSum;

   @Column(nullable = false)
   private int countOfSavedPets;

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public Set<Volunteer> getShelterVolunteers()
   {
      return shelterVolunteers;
   }

   public void setShelterVolunteers(Set<Volunteer> shelterVolunteers)
   {
      this.shelterVolunteers = shelterVolunteers;
   }

   public Set<Veterinarian> getVeterinarians()
   {
      return veterinarians;
   }

   public void setVeterinarians(Set<Veterinarian> veterinarians)
   {
      this.veterinarians = veterinarians;
   }

   public Set<Pet> getPets()
   {
      return pets;
   }

   public void setPets(Set<Pet> pets)
   {
      this.pets = pets;
   }

   public Double getSubsidiesSum()
   {
      return subsidiesSum;
   }

   public void setSubsidiesSum(Double countrySubsidiesSum)
   {
      this.subsidiesSum = countrySubsidiesSum;
   }

   public int getCountOfSavedPets()
   {
      return countOfSavedPets;
   }

   public void setCountOfSavedPets(int countOfSavedPets)
   {
      this.countOfSavedPets = countOfSavedPets;
   }
}
