package com.example.patternsanddeepspring.interpreter.entity;

//Abstract expression
public interface PermissionExpression {

	boolean interpret(User user); 
}
