package com.example.patterns.proxy.entity;


//Interface implemented by proxy and concrete objects
public interface Image {

	void setLocation(int x);
	
	int getLocation();
	
	void render();
	
}
