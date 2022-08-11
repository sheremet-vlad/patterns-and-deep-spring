package com.example.patterns.observer.controller;

import com.example.patterns.objectPool.ObjectPool;
import com.example.patterns.objectPool.entity.Image;
import com.example.patterns.observer.entity.Order;
import com.example.patterns.observer.entity.PriceObserver;
import com.example.patterns.observer.entity.QuantityObserver;
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

