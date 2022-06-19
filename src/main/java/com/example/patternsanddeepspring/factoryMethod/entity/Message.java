package com.example.patternsanddeepspring.factoryMethod.entity;

/**
 * This class represents interface for our "product" which is a message
 * Implementations will be specific to content type.
 *
 */
public abstract class Message {

	public abstract String getContent();
	
	public void addDefaultHeaders() {
		throw new UnsupportedOperationException();
	}
	
	public void encrypt() {
		throw new UnsupportedOperationException();
	}
	
}
