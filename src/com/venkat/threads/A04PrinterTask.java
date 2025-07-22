package com.venkat.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Runnable class for each thread
public class A04PrinterTask implements Runnable {
	
	private final A03LockPrinter printer;
    private final int threadId;
    
    public A04PrinterTask(A03LockPrinter printer, int threadId) {
        this.printer = printer;
        this.threadId = threadId;
    }

	@Override
	public void run() {
		printer.print(threadId);
	}
	
	
	public static void main(String[] args) {
		int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80};
		A03LockPrinter lockPrinter = new A03LockPrinter(numbers);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(new A04PrinterTask(lockPrinter, 0));
		executor.execute(new A04PrinterTask(lockPrinter, 1));
		executor.execute(new A04PrinterTask(lockPrinter, 2));
		
		executor.shutdown();
	}

}
