package com.venkat.designpattern.abstractfactory;

public class Client {
	private final Button button;
    private final Checkbox checkbox;

    public Client(UIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }
    
    public void renderUI() {
        button.render();
        checkbox.check();
    }
    
    public static void main(String[] args) {
        UIFactory windowsFactory = new WindowsUIFactory();
        Client windowsClient = new Client(windowsFactory);
        windowsClient.renderUI();

        UIFactory macOSFactory = new MacOSUIFactory();
        Client macOSClient = new Client(macOSFactory);
        macOSClient.renderUI();
    }
}
