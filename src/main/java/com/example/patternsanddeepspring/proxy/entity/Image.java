package com.example.patternsanddeepspring.proxy.entity;


//Interface implemented by proxy and concrete objects
public interface Image {

	void setLocation(int x);
	
	int getLocation();
	
	void render();
	
}
