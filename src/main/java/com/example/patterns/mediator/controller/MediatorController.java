package com.example.patterns.mediator.controller;

import com.example.patterns.mediator.entity.Label;
import com.example.patterns.mediator.entity.Slider;
import com.example.patterns.mediator.entity.TextBox;
import com.example.patterns.mediator.entity.UIMediator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

