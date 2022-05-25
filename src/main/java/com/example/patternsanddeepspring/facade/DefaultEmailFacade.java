package com.example.patternsanddeepspring.facade;

import com.example.patternsanddeepspring.facade.entity.Email;
import com.example.patternsanddeepspring.facade.entity.Mailer;
import com.example.patternsanddeepspring.facade.entity.Order;
import com.example.patternsanddeepspring.facade.entity.Stationary;
import com.example.patternsanddeepspring.facade.entity.StationaryFactory;
import com.example.patternsanddeepspring.facade.entity.Template;
import com.example.patternsanddeepspring.facade.entity.TemplateFactory;

//Facade provides simple methods for client to use
public class DefaultEmailFacade implements EmailFacade
{
   @Override
   public boolean sendOrderEmailWithoutFacade(Order order) {
      Template template = TemplateFactory.createTemplateFor(Template.TemplateType.Email);
      Stationary stationary = StationaryFactory.createStationary();
      Email email = Email.getBuilder()
               .withTemplate(template)
               .withStationary(stationary)
               .forObject(order)
               .build();
      Mailer mailer = Mailer.getMailer();
      return mailer.send(email);
   }
}
