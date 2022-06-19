package com.example.patternsanddeepspring.decorator.entity;

//Concrete component. Object to be decorated
public class TextMessage implements Message {

	private String msg; // don't use short names
	
	public TextMessage(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String getContent() {
		return msg;
	}
}
