package com.example.patterns.facade;

import com.example.patterns.facade.entity.Email;
import com.example.patterns.facade.entity.Mailer;
import com.example.patterns.facade.entity.Order;
import com.example.patterns.facade.entity.Stationary;
import com.example.patterns.facade.entity.StationaryFactory;
import com.example.patterns.facade.entity.Template;
import com.example.patterns.facade.entity.TemplateFactory;
import org.springframework.stereotype.Service;

//Facade provides simple methods for client to use
@Service
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
