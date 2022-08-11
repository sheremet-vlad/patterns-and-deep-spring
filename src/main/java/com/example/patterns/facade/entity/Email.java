package com.example.patterns.facade.entity;

public class Email {

	public static EmailBuilder getBuilder() {
		return new EmailBuilder();
	}
}
