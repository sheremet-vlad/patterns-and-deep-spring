package com.example.patterns.proxy.controller;

import com.example.patterns.proxy.entity.Image;
import com.example.patterns.proxy.entity.ImageFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProxyController
{
   @Resource
   private ImageFactory imageFactory;

   @GetMapping("/proxy")
   public String proxy()
   {
      Image image = imageFactory.createImage("a1.bmp");
      image.render();

      return "result of image render was printed to the console";
   }
}

