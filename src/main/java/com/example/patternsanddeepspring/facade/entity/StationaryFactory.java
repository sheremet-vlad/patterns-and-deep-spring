package com.example.patternsanddeepspring.facade.entity;

public class StationaryFactory {

	public static Stationary createStationary() {
		return new HalloweenStationary();
	}
}
