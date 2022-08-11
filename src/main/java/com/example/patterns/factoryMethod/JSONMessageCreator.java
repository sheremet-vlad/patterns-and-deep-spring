package com.example.patterns.factoryMethod;

import com.example.patterns.factoryMethod.entity.JSONMessage;
import com.example.patterns.factoryMethod.entity.Message;

/**
 * Provides implementation for creating JSON messages
 */
public class JSONMessageCreator extends MessageCreator {
   @Override
   protected Message createMessage()
   {
      return new JSONMessage();
   }
}
