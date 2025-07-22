package com.venkat.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A01PrintArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		A03LockPrinter printer = new A03LockPrinter(arr);

        Thread t0 = new Thread(() -> printer.print(0), "Thread-0");
        Thread t1 = new Thread(() -> printer.print(1), "Thread-1");
        Thread t2 = new Thread(() -> printer.print(2), "Thread-2");

        t0.start();
        t1.start();
        t2.start();
        
        try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("-----------");
        
        A02SyncPrinter syncPrinter = new A02SyncPrinter(arr);
        t0 = new Thread(() -> syncPrinter.print(0), "Thread-0");
        t1 = new Thread(() -> syncPrinter.print(1), "Thread-1");
        t2 = new Thread(() -> syncPrinter.print(2), "Thread-2");

        t0.start();
        t1.start();
        t2.start();
        
        try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("-----------");
        
        A03LockPrinter executorPrinter = new A03LockPrinter(arr);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> executorPrinter.print(0));
        executor.submit(() -> executorPrinter.print(1));
        executor.submit(() -> executorPrinter.print(2));
        
        executor.shutdown();
	}

}
