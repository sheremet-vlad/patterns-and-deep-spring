package com.example.patternsanddeepspring.interpreter.entity;

//Terminal expression
public class Permission implements PermissionExpression {
   private String permission;

   public Permission(String permission)
   {
      this.permission = permission.toLowerCase();
   }

   @Override
   public boolean interpret(User user)
   {
      return user.getPermissions().contains(permission);
   }
}
