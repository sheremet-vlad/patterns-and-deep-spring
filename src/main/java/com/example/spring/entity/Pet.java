package com.example.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pet
{
   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY)
   private int id;

   @Column(nullable = false, length = 100)
   private String name;

   @Column(nullable = false, length = 100)
   private int age;

   @ManyToOne
   @JoinColumn(name = "volunteer_id")
   private Volunteer volunteer;

   @ManyToOne
   @JoinColumn(name = "veterinarian_id")
   private Veterinarian veterinarian;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "shelter_id")
   private Shelter petShelter;

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

   public int getAge()
   {
      return age;
   }

   public void setAge(int age)
   {
      this.age = age;
   }

   public Volunteer getVolunteer()
   {
      return volunteer;
   }

   public void setVolunteer(Volunteer volunteer)
   {
      this.volunteer = volunteer;
   }

   public Veterinarian getVeterinarian()
   {
      return veterinarian;
   }

   public void setVeterinarian(Veterinarian veterinarian)
   {
      this.veterinarian = veterinarian;
   }

   public Shelter getPetShelter()
   {
      return petShelter;
   }

   public void setPetShelter(Shelter petShelter)
   {
      this.petShelter = petShelter;
   }
}
