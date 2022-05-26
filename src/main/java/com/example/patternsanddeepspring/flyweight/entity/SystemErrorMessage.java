package com.example.patternsanddeepspring.flyweight.entity;

//A concrete Flyweight. Instance is shared
public class SystemErrorMessage implements ErrorMessage{
   private String template;
   private String url;

   public SystemErrorMessage(String template, String url)
   {
      this.template = template;
      this.url = url;
   }

   @Override
   public String getText(String code)
   {
      return String.format(template, url);
   }

   public String getTemplate()
   {
      return template;
   }

   public void setTemplate(String template)
   {
      this.template = template;
   }

   public String getUrl()
   {
      return url;
   }

   public void setUrl(String url)
   {
      this.url = url;
   }
}
