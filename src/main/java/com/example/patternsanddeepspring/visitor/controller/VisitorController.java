package com.example.patternsanddeepspring.visitor.controller;

import com.example.patternsanddeepspring.templatemethod.entity.Order;
import com.example.patternsanddeepspring.templatemethod.entity.OrderPrinter;
import com.example.patternsanddeepspring.visitor.entity.Employee;
import com.example.patternsanddeepspring.visitor.entity.Manager;
import com.example.patternsanddeepspring.visitor.entity.PrintVisitor;
import com.example.patternsanddeepspring.visitor.entity.Programmer;
import com.example.patternsanddeepspring.visitor.entity.ProjectLead;
import com.example.patternsanddeepspring.visitor.entity.VicePresident;
import com.example.patternsanddeepspring.visitor.entity.Visitor;
import org.springframework.format.Printer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class VisitorController
{
   @Resource
   private Visitor printVisitor;

   @GetMapping("/visitor")
   public String visitor()
   {
      final Employee employee = buildOrganization();
      printEmployeeInfo(employee, printVisitor);

      return "result visitor pattern printed to console";
   }

   private Employee buildOrganization()
   {

      Programmer p1 = new Programmer("Rachel", "C++");
      Programmer p2 = new Programmer("Andy", "Java");

      Programmer p3 = new Programmer("Josh", "C#");
      Programmer p4 = new Programmer("Bill", "C++");

      ProjectLead pl1 = new ProjectLead("Tina", p1, p2);
      ProjectLead pl2 = new ProjectLead("Joey", p3, p4);

      Manager m1 = new Manager("Chad", pl1);
      Manager m2 = new Manager("Chad II", pl2);

      VicePresident vp = new VicePresident("Richard", m1, m2);

      return vp;
   }

   public void printEmployeeInfo(final Employee employee, final Visitor visitor)
   {
      employee.accept(visitor);
      employee.getDirectReports().forEach(e -> e.accept(visitor));
   }
}

