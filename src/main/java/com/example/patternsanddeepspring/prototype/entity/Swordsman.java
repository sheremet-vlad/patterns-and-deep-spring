package com.example.patternsanddeepspring.prototype.entity;

public class Swordsman extends GameUnit {

	private String name = "unit sw";

	public void boostMorale() {
		this.name = "MoralBoost";
	}

	@Override
	public String toString() {
		return "Swordsman "+ name +", count:@ " + getCount();
	}

}
