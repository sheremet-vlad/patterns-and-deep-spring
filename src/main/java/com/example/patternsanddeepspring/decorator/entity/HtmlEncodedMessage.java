package com.example.patternsanddeepspring.decorator.entity;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

//Decorator. Implements component interface
public class HtmlEncodedMessage implements Message {
   private Message message;

   public HtmlEncodedMessage(Message message)
   {
      this.message = message;
   }

   @Override
   public String getContent()
   {
      return StringEscapeUtils.escapeHtml4((message.getContent()));
   }
}
