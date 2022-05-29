package com.example.patternsanddeepspring.mediator.entity;

public class TextBox implements UIControl{
	
	private UIMediator mediator;
	private String text;
	
	private boolean mediatedUpdate;
	
	public TextBox(UIMediator mediator) {
		this.mediator = mediator;
		this.setText("Textbox");
		this.mediator.register(this);

		/*this.textProperty().addListener((v, o, n) -> {
			if(!mediatedUpdate)
				this.mediator.valueChanged(this);
		});*/
	}

	@Override
	public void controlChanged(UIControl control) {
		this.mediatedUpdate = true;
		this.setText(control.getControlValue());
		this.mediatedUpdate = false;
	}

	@Override
	public String getControlValue() {
		return getText();
	}

	@Override
	public String getControlName() {
		return "Textbox";
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}
}
