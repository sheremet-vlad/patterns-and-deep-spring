package com.example.patternsanddeepspring.decorator.entity;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

//Decorator. Implements component interface .Wrapper
public class HtmlEncodedMessageDecorator implements Message {
   private Message message;

   public HtmlEncodedMessageDecorator(Message message)
   {
      this.message = message;
   }

   //wrapper often can wrap itself

   @Override
   public String getContent()
   {
      return StringEscapeUtils.escapeHtml4((message.getContent()));
   }
}
