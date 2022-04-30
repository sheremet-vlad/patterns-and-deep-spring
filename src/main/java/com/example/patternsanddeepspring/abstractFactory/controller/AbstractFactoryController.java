package com.example.patternsanddeepspring.abstractFactory.controller;

import com.example.patternsanddeepspring.abstractFactory.entity.Instance;
import com.example.patternsanddeepspring.abstractFactory.entity.ResourceFactory;
import com.example.patternsanddeepspring.abstractFactory.entity.Storage;
import com.example.patternsanddeepspring.abstractFactory.entity.aws.AwsResourceFactory;
import com.example.patternsanddeepspring.abstractFactory.entity.gcp.GoogleResourceFactory;
import com.example.patternsanddeepspring.factoryMethod.JSONMessageCreator;
import com.example.patternsanddeepspring.factoryMethod.TextMessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbstractFactoryController
{
   @GetMapping("/abstractFactory")
   public String factoryMethod()
   {
      final StringBuilder builder = new StringBuilder();

      final ResourceFactory awsResourceFactory = new AwsResourceFactory();
      final Instance awsInstance = awsResourceFactory.createInstance(Instance.Capacity.small);
      final Storage s3sStorage = awsResourceFactory.allocateStorage(200);
      awsInstance.attachStorage(s3sStorage);

      final ResourceFactory googleResourceFactory = new GoogleResourceFactory();
      final Instance googleInstance = googleResourceFactory.createInstance(Instance.Capacity.small);
      final Storage googleStorage = googleResourceFactory.allocateStorage(100);
      googleInstance.attachStorage(googleStorage);

      builder.append("build via abstract factory").append("\n");
      builder.append("aws instance: ").append(awsInstance).append("\n");
      builder.append("google instance: ").append(googleInstance).append("\n");

      return builder.toString();
   }
}

