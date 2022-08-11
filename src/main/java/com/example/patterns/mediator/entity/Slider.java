package com.example.patterns.mediator.entity;

public class Slider implements UIControl{

	private UIMediator mediator;
	private boolean mediatedUpdate;
	private String value;
	
	public Slider(UIMediator mediator) {
		this.mediator = mediator;
		mediator.register(this);
		//this.addListener((v,o,n) ->{if(!mediatedUpdate) this.mediator.valueChanged(this);});
	}
	
	@Override
	public void controlChanged(UIControl control) {
		mediatedUpdate = true;
		setValue("double");
		mediatedUpdate = false;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	@Override
	public String getControlName() {
		return "Slider";
	}

	@Override
	public String getControlValue() {
		return "One";
	}
	

}
