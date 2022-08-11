package com.example.patterns.prototype.entity;

//Doesn't support cloning
public class General extends GameUnit {

	private String name = "general";

	public void boostMorale() {
		this.name = "MoralBoost";
	}

	@Override
	public GameUnit clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
	}

	@Override
	public String toString() {
		return "General "+ name +", count:@ " + getCount();
	}
}
