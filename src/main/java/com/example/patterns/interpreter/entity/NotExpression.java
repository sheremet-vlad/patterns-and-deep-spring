package com.example.patterns.interpreter.entity;

public class NotExpression implements PermissionExpression {
	
	private PermissionExpression expression;
	
	public NotExpression(PermissionExpression expression) {
		this.expression = expression;
	}

	@Override
	public boolean interpret(User user) {
		return !expression.interpret(user);
	}
	
	@Override
	public String toString() {
		return " NOT "+expression;
	}
}
