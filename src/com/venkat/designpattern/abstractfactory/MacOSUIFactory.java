package com.venkat.designpattern.abstractfactory;

public class MacOSUIFactory implements UIFactory {

	@Override
	public Button createButton() {
		return new MacOSButton();
	}

	@Override
	public Checkbox createCheckbox() {
		return new MacOSCheckbox();
	}

}
