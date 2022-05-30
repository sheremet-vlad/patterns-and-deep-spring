package com.example.patternsanddeepspring.mediator.controller;

import com.example.patternsanddeepspring.interpreter.entity.ExpressionBuilder;
import com.example.patternsanddeepspring.interpreter.entity.PermissionExpression;
import com.example.patternsanddeepspring.interpreter.entity.Report;
import com.example.patternsanddeepspring.interpreter.entity.User;
import com.example.patternsanddeepspring.mediator.entity.Label;
import com.example.patternsanddeepspring.mediator.entity.Slider;
import com.example.patternsanddeepspring.mediator.entity.TextBox;
import com.example.patternsanddeepspring.mediator.entity.UIMediator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MediatorController
{

   @GetMapping("/mediator")
   public String mediator()
   {
      //need java fx to see full example
      UIMediator mediator = new UIMediator();
      Slider slider = new Slider(mediator);
      TextBox box = new TextBox(mediator);
      Label label = new Label(mediator);

      return "component was build via mediator pattern";
   }
}

