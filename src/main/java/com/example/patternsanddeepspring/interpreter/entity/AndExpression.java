package com.example.patternsanddeepspring.interpreter.entity;

//Non-terminal expression 
public class AndExpression implements PermissionExpression {
   private PermissionExpression expression1;
   private PermissionExpression expression2;

   public AndExpression(PermissionExpression one, PermissionExpression two) {
      this.expression1 = one;
      this.expression2 = two;
   }

   @Override
   public boolean interpret(User user)
   {
      return expression1.interpret(user) && expression2.interpret(user);
   }
}
