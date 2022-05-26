package com.example.patternsanddeepspring.flyweight.entity;

//Interface implemented by Flyweights
public interface ErrorMessage {
	//Get error message
	String getText(String code);
}
