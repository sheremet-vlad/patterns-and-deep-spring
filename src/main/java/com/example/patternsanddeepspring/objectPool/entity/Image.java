package com.example.patternsanddeepspring.objectPool.entity;

public interface Image extends Poolable
{
   String getName();

   String getLocation();

   void setLocation(int x, int y);

   String draw();
}
