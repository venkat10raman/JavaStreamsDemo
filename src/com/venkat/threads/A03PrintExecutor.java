package com.venkat.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class A03PrintExecutor {

	public static void main(String[] args) throws InterruptedException {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		A03LockPrinter printer = new A03LockPrinter(arr);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(() -> printer.print(0));
        executor.execute(() -> printer.print(1));
        executor.execute(() -> printer.print(2));
        
        executor.shutdown();
        
        if(executor.awaitTermination(1, TimeUnit.MILLISECONDS)) {System.out.println("******");}
        System.out.println("-----------");
        
        A03LockPrinter executorPrinter = new A03LockPrinter(arr);
        executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> executorPrinter.print(0));
        executor.submit(() -> executorPrinter.print(1));
        executor.submit(() -> executorPrinter.print(2));
        
        executor.shutdown();
	}

}
