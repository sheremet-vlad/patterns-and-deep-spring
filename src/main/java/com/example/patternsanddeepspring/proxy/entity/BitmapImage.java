package com.example.patternsanddeepspring.proxy.entity;


//Our concrete class providing actual functionality
public class BitmapImage implements Image {
	
	private int x;
	private String name;
	
	public BitmapImage(String filename) {
		//Loads image from file on disk
		System.out.println("Loaded from disk:"+filename);
		name = filename;
	}
	
	@Override
	public void setLocation(int x) {
		this.x = x;
	}

	@Override
	public int getLocation() {
		return x;
	}

	@Override
	public void render() {
		//renders to screen
		System.out.println("Rendered "+this.name);
	}
	
}
