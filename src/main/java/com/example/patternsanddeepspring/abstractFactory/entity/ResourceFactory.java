package com.example.patternsanddeepspring.abstractFactory.entity;

//Abstract factory with methods defined for each object type.
public interface ResourceFactory {
   Instance createInstance(final Instance.Capacity capacity);

   Storage allocateStorage(final int size);
}
