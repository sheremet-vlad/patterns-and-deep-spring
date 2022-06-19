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

   //Strange mapping selection - Get usually uses for READ
   //If it's a READ method I'd expect to get status code if everything is ok. Use @ResponseStatus annotation
   //factoryMethod could return diff types for the same interface. I'd like to have two endpoints with reasonable names https://blog.dreamfactory.com/best-practices-for-naming-rest-api-endpoints/#:~:text=REST%20APIs%20are%20typically%20structured,to%20right%20in%20the%20URI.
   //-----/storage/{storageProvider}/{capacity}/{size} - if strategy is used
   //OR
   // two endpoints /storage/aws/{capacity}/{size} and /storage/google/{capacity}/{size}

   @GetMapping("/abstractFactory")
   public String factoryMethod()
   {
      final StringBuilder builder = new StringBuilder();

      //I don't expect so much logic in controller. Use DI, make Factories as bean, try to make Instance a prototype bean
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

      //convert to json, It's more convenient
      return builder.toString(); //use Jakson lib and make spring convert object to JSON automatically
   }
}

