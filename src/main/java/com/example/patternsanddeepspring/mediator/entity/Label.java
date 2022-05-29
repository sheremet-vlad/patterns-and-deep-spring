package com.example.patternsanddeepspring.mediator.entity;

public class Label implements UIControl{

	private UIMediator mediator;
	private String text;
	
	public Label(UIMediator mediator) {
		this.mediator = mediator;
		this.setText("Label");
		mediator.register(this);
	}

	public UIMediator getMediator()
	{
		return mediator;
	}

	public void setMediator(UIMediator mediator)
	{
		this.mediator = mediator;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	@Override
	public void controlChanged(UIControl control) {
		setText(control.getControlValue());
	}

	@Override
	public String getControlValue() {
		return getText();
	}

	@Override
	public String getControlName() {
		return "Label";
	}

	
}
