package com.example.patternsanddeepspring.objectPool;

import com.example.patternsanddeepspring.objectPool.entity.Poolable;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

@Service
public class ObjectPool<T extends Poolable>
{
   private final BlockingQueue<T> pool = new LinkedBlockingQueue<>();

   private ObjectPool() {

   }

   public void initPool(final Supplier<T> supplier, final int count)
   {
      for (int i = 0; i < count; i++)
      {
         pool.add(supplier.get());
      }
   }

   public T get()
   {
      try
      {
         return pool.take();
      }
      catch (InterruptedException e)
      {
         System.out.println("take is interrupted");
      }

      return null;
   }

   public void release(T t)
   {
      t.reset();
      try
      {
          pool.put(t);
      }
      catch (InterruptedException e)
      {
         System.out.println("put is interrupted");
      }
   }

}
