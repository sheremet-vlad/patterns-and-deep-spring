package com.example.patterns.chainofresponsibility.controller;

import com.example.patterns.chainofresponsibility.entity.Director;
import com.example.patterns.chainofresponsibility.entity.LeaveApplication;
import com.example.patterns.chainofresponsibility.entity.LeaveApprover;
import com.example.patterns.chainofresponsibility.entity.Manager;
import com.example.patterns.chainofresponsibility.entity.ProjectLead;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class ChainOfResponsibilityController
{

   @GetMapping("/chainOfResponsibility")
   public String composite()
   {
      LeaveApplication application = LeaveApplication.getBuilder().withType(LeaveApplication.Type.Sick)
               .from(LocalDate.now()).to(LocalDate.of(2018, 2, 28))
               .build();

      LeaveApprover approver = createChain();
      approver.processLeaveApplication(application);

      return application.toString();
   }

   private static LeaveApprover createChain() {
      Director director = new Director(null);
      Manager manager = new Manager(director);
      return new ProjectLead(manager);
   }

}

