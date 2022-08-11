package com.example.patterns.objectPool.controller;

import com.example.patterns.objectPool.ObjectPool;
import com.example.patterns.objectPool.entity.Image;
import com.example.patterns.objectPool.entity.PngImage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ObjectPoolController
{
   @Resource
   private ObjectPool<Image> imageObjectPool;

   @GetMapping("/objectPool")
   public String factoryMethod() throws CloneNotSupportedException
   {
      imageObjectPool.initPool(() -> new PngImage("png image"), 5);

      final Image image1 = imageObjectPool.get();
      final Image image2 = imageObjectPool.get();

      image1.setLocation(1, 1);
      image2.setLocation(2,2);

      StringBuilder resultLog = new StringBuilder("Log of image drawn: \n");
      resultLog.append(image1.draw()).append("\n");
      resultLog.append(image2.draw()).append("\n");

      imageObjectPool.release(image1);
      imageObjectPool.release(image2);

      return resultLog.toString();
   }
}

