package com.example.patterns.objectPool.entity;

public interface Image extends Poolable
{
   String getName();

   String getLocation();

   void setLocation(int x, int y);

   String draw();
}
