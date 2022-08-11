package com.example.patterns.interpreter.entity;

//Abstract expression
public interface PermissionExpression {

	boolean interpret(User user); 
}
