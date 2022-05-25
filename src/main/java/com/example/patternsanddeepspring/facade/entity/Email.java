package com.example.patternsanddeepspring.facade.entity;

public class Email {

	public static EmailBuilder getBuilder() {
		return new EmailBuilder();
	}
}
