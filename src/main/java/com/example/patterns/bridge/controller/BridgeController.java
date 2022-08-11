package com.example.patterns.bridge.controller;

import com.example.patterns.bridge.entity.ArrayLinkedList;
import com.example.patterns.bridge.entity.FifoCollection;
import com.example.patterns.bridge.entity.Queue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BridgeController
{

   @GetMapping("/bridge")
   public String factoryMethod() throws CloneNotSupportedException
   {
      final FifoCollection<Integer> integerFifoCollection = new Queue<>(new ArrayLinkedList<>());
      integerFifoCollection.offer(10);

      return "polled element:" + integerFifoCollection.poll();
   }
}

