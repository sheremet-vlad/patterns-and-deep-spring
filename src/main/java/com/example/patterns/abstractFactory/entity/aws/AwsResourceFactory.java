package com.example.patterns.abstractFactory.entity.aws;

import com.example.patterns.abstractFactory.entity.Instance;
import com.example.patterns.abstractFactory.entity.ResourceFactory;
import com.example.patterns.abstractFactory.entity.Storage;

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
