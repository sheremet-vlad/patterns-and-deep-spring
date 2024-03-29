package com.example.patterns.factoryMethod;

import com.example.patterns.factoryMethod.entity.Message;

/**
 * This is our abstract "creator". 
 * The abstract method createMessage() has to be implemented by
 * its subclasses.
 */
public abstract class MessageCreator {
   public Message getMessage()
   {
      final Message message = createMessage();

      message.addDefaultHeaders();
      message.encrypt();

      return message;
   }

   protected abstract Message createMessage();
}
