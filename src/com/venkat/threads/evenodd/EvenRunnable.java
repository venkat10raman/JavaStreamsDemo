package com.venkat.threads.evenodd;

public class EvenRunnable implements Runnable {
	
	private final LockPrinter printer;
	
	public EvenRunnable(LockPrinter printer) {
		this.printer = printer;
	}

	@Override
	public void run() {
		printer.printEven();
	}

}
