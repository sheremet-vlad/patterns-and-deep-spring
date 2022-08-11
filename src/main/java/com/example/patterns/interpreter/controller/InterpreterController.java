package com.example.patterns.interpreter.controller;

import com.example.patterns.interpreter.entity.ExpressionBuilder;
import com.example.patterns.interpreter.entity.PermissionExpression;
import com.example.patterns.interpreter.entity.Report;
import com.example.patterns.interpreter.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class InterpreterController
{
   @Resource
   private ExpressionBuilder builder;

   @GetMapping("/interpreter")
   public String interpreter()
   {
      final Report report = new Report("report 1", "admin");
      final PermissionExpression exp = builder.build(report);

      final User user1 = new User("Admin", "admin");
      final User user2 = new User("Not admin", "not admin");

      return String.format("User have permission to report: %s; %s - %s, %s - %s", report,
               user1.getUsername(), exp.interpret(user1),
               user2.getUsername(), exp.interpret(user2));
   }
}

