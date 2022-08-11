package com.example.patterns.abstractFactory.entity.gcp;

import com.example.patterns.abstractFactory.entity.Instance;
import com.example.patterns.abstractFactory.entity.ResourceFactory;
import com.example.patterns.abstractFactory.entity.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {
   @Override
   public Instance createInstance(Instance.Capacity capacity)
   {
      return new GoogleComputeEngineInstance(capacity);
   }

   @Override
   public Storage allocateStorage(int size)
   {
      return new GoogleCloudStorage(size);
   }
}
