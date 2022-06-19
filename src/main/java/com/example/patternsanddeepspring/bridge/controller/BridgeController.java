package com.example.patternsanddeepspring.bridge.controller;

import com.example.patternsanddeepspring.bridge.entity.ArrayLinkedList;
import com.example.patternsanddeepspring.bridge.entity.FifoCollection;
import com.example.patternsanddeepspring.bridge.entity.Queue;
import com.example.patternsanddeepspring.objectPool.ObjectPool;
import com.example.patternsanddeepspring.objectPool.entity.Image;
import com.example.patternsanddeepspring.objectPool.entity.PngImage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BridgeController
{

   @GetMapping("/bridge")
   //bad method name etc
   public String factoryMethod() throws CloneNotSupportedException
   {

      //it's not a bridge pattern more like wrapper
      final FifoCollection<Integer> integerFifoCollection = new Queue<>(new ArrayLinkedList<>());
      integerFifoCollection.offer(10);

      return "polled element:" + integerFifoCollection.poll();
   }
}

