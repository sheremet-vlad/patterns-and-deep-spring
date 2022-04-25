package com.example.patternsanddeepspring.factoryMethod;

import com.example.patternsanddeepspring.factoryMethod.entity.JSONMessage;
import com.example.patternsanddeepspring.factoryMethod.entity.Message;

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
