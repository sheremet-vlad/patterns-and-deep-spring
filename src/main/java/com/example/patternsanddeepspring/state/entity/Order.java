package com.example.patternsanddeepspring.state.entity;

//Context class
public class Order {
	private OrderState currentState;
	
	public double cancel() {
		double result = currentState.handleCancellation();
		currentState = new Cancelled();
		return result;
	}
   
	public void paymentSuccessful() {
		currentState = new Paid();
	}
	
	public void dispatched() {
		currentState = new InTransit();
	}
	
	public void delivered() {
		currentState = new Delivered();
	}
}
