package com.example.patternsanddeepspring.observer.controller;

import com.example.patternsanddeepspring.objectPool.ObjectPool;
import com.example.patternsanddeepspring.objectPool.entity.Image;
import com.example.patternsanddeepspring.objectPool.entity.PngImage;
import com.example.patternsanddeepspring.observer.entity.Order;
import com.example.patternsanddeepspring.observer.entity.PriceObserver;
import com.example.patternsanddeepspring.observer.entity.QuantityObserver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ObserverController
{
   @Resource
   private ObjectPool<Image> imageObjectPool;

   @GetMapping("/observer")
   public String factoryMethod() throws CloneNotSupportedException
   {
      final Order order = new Order("product1");
      order.addItem(10);

      order.attach(new PriceObserver());
      order.attach(new QuantityObserver());

      order.addItem(100);

      return "observer result printed to console";
   }
}

