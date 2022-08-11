package com.example.patterns.proxy.entity;

//Proxy class.
public class ImageProxy implements Image{
   private Image image;
   private String fileName;
   private int x;

   public ImageProxy(String fileName)
   {
      this.fileName = fileName;
   }

   @Override
   public void setLocation(int x)
   {
      if (image == null)
      {
         this.x = x;
      }
      else
      {
         image.setLocation(x);
      }
   }

   @Override
   public int getLocation()
   {
      if (image != null)
      {
         return image.getLocation();
      }
      return x;
   }

   @Override
   public void render()
   {
      if (image == null)
      {
         image = new BitmapImage(fileName);
         if (x != 0)
         {
            image.setLocation(x);
         }
      }
      image.render();
   }
}
