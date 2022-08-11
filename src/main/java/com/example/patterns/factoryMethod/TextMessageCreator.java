package com.example.patterns.factoryMethod;

import com.example.patterns.factoryMethod.entity.Message;
import com.example.patterns.factoryMethod.entity.TextMessage;

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
