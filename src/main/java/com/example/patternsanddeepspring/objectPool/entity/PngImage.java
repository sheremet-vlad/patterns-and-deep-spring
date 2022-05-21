package com.example.patternsanddeepspring.objectPool.entity;

import java.util.Objects;

public class PngImage implements Image
{
   private String name;
   private int x;
   private int y;

   public PngImage(String name)
   {
      this.name = name;
   }

   @Override
   public String getName()
   {
      return name;
   }


   @Override
   public String getLocation()
   {
      return String.format("Location x: %s, y: %s", x, y);
   }

   @Override
   public void reset()
   {
      x = 0;
      y = 0;
   }

   @Override
   public void setLocation(int x, int y)
   {
      this.x = x;
      this.y = y;
   }

   @Override
   public String draw()
   {
      return String.format("Image: %s, drawn in x: %s, y: %s", name, x, y);
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      PngImage pngImage = (PngImage) o;
      return x == pngImage.x && y == pngImage.y && Objects.equals(name, pngImage.name);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(name, x, y);
   }

   @Override
   public String toString()
   {
      return "PngImage{" +
               "name='" + name + '\'' +
               ", x=" + x +
               ", y=" + y +
               '}';
   }
}
