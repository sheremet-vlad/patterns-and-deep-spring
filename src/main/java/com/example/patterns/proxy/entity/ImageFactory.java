package com.example.patterns.proxy.entity;

import org.springframework.stereotype.Service;

//Factory to get image objects.
@Service
public class ImageFactory {
	public Image createImage(final String fileName)
   {
      return new ImageProxy(fileName);
   }
}
