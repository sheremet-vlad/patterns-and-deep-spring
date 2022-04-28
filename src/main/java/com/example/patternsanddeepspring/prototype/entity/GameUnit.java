package com.example.patternsanddeepspring.prototype.entity;

/**
 * This class represents an abstract prototype & defines the clone method
 */
public abstract class GameUnit implements Cloneable {
	private Integer count;

	@Override
	public GameUnit clone() throws CloneNotSupportedException
	{
		GameUnit gameUnit = (GameUnit) super.clone();
		init(gameUnit);
		return gameUnit;
	}

	private void init(final GameUnit gameUnit)
	{
		gameUnit.setCount(1);
	}

	public Integer getCount()
	{
		return count;
	}

	public void setCount(Integer count)
	{
		this.count = count;
	}
}
