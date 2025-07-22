package com.venkat.threads.evenodd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {
		test();
		System.out.println("-----------------");
		testWithExecutor();
		System.out.println("-----------------");
		testWithRunnableExecutor();
	}
	
	public static void test() {
		int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10};

        LockPrinter printer = new LockPrinter(array);

        Thread evenThread = new Thread(printer::printEven, "Thread-Even");
        Thread oddThread = new Thread(printer::printOdd, "Thread-Odd");

        evenThread.start();
        oddThread.start();
        
        try {
			oddThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void testWithExecutor() {
		int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10};

        LockPrinter printer = new LockPrinter(array);
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(printer::printOdd);
        executor.execute(printer::printEven);
        
        
        executor.shutdown();
        
        try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void testWithRunnableExecutor() {
		int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10};

        LockPrinter printer = new LockPrinter(array);
        
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new OddRunnable(printer));
        executor.execute(new EvenRunnable(printer));
        
        executor.shutdown();
	}

}
