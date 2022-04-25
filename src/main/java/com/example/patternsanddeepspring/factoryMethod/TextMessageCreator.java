package com.example.patternsanddeepspring.factoryMethod;

import com.example.patternsanddeepspring.factoryMethod.entity.Message;
import com.example.patternsanddeepspring.factoryMethod.entity.TextMessage;

/**
 * Provides implementation for creating Text messages
 */
public class TextMessageCreator extends MessageCreator {
   @Override
   protected Message createMessage()
   {
      return new TextMessage();
   }
}
