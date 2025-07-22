package com.venkat.threads.producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
		testWithExecutor();
	}
	
	public static void test() {
		LockBlockQueue queue = new LockBlockQueue(5);
		
		 // Start 2 producers
       for (int i = 0; i < 2; i++) {
           Thread producerThread = new Thread(new Producer(queue), "Producer-" + i);
           producerThread.start();
       }

       // Start 3 consumers
       for (int i = 0; i < 3; i++) {
           Thread consumerThread = new Thread(new Consumer(queue), "Consumer-" + i);
           consumerThread.start();
       }
	}
	
	
	public static void testWithExecutor() {
		LockBlockQueue queue = new LockBlockQueue(5);
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.execute(new Producer(queue));
		executor.execute(new Producer(queue));
		
		executor.execute(new Consumer(queue));
		executor.execute(new Consumer(queue));
		executor.execute(new Consumer(queue));
		
	}

}
