package com.example.patternsanddeepspring.abstractFactory.entity.aws;

import com.example.patternsanddeepspring.abstractFactory.entity.Instance;
import com.example.patternsanddeepspring.abstractFactory.entity.ResourceFactory;
import com.example.patternsanddeepspring.abstractFactory.entity.Storage;

//Factory implementation for Google cloud platform resources
public class AwsResourceFactory implements ResourceFactory {

   @Override
   public Instance createInstance(Instance.Capacity capacity)
   {
      return new Ec2Instance(capacity);
   }

   @Override
   public Storage allocateStorage(int size)
   {
      return new S3Storage(size);
   }
}
