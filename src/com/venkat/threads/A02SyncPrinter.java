package com.venkat.threads;

public class A02SyncPrinter {
	
	private final int[] arr;
    private int index = 0;
    private int turn = 0;
    
    public A02SyncPrinter(int[] arr) {
    	this.arr = arr;
    }
    
    public void print(int threadId) {
    	while(true) {
    		synchronized (this) {
				while(index < arr.length && turn != threadId) {
					try {
						wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						e.printStackTrace();
						return;
					}
				}
				
				if(index >= arr.length) {
					notifyAll();
					return;
				}
				
				System.out.println(Thread.currentThread().getName() + " prints: " + arr[index]);
                index++;
                turn = (turn + 1) % 3;
                notifyAll();
			}
    	}
    }

}
