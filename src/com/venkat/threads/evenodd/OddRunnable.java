package com.venkat.threads.evenodd;

public class OddRunnable implements Runnable {
	
private final LockPrinter printer;
	
	public OddRunnable(LockPrinter printer) {
		this.printer = printer;
	}

	@Override
	public void run() {
		printer.printOdd();
	}

}
