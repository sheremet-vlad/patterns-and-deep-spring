package com.example.patterns.decorator.entity;

import org.apache.commons.lang3.StringEscapeUtils;

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
