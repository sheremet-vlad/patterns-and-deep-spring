package com.example.patternsanddeepspring.factoryMethod.entity;

public class JSONMessage extends Message {

	@Override
	public String getContent() {
		return "{\"JSON]\":[]}";
	}
	
}
