package com.example.patternsanddeepspring.facade.entity;

public abstract class Template {

	public enum TemplateType {Email, NewsLetter};
	
	public abstract String format(Object obj);
	
}
