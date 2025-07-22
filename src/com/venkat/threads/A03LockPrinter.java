package com.venkat.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class A03LockPrinter {
	
	private final int[] arr;
    private int index = 0;
    private int turn = 0;

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public A03LockPrinter(int[] arr) {
        this.arr = arr;
    }
    
    public void print(int threadId) {
    	while(true) {
    		lock.lock();
    		
    		try {
    			while(index < arr.length && turn != threadId) {
    				condition.await();
    			}
    			
    			if(index >= arr.length) {
    				condition.signalAll();
    				return;
    			}
    			
    			System.out.println(Thread.currentThread().getName() + " prints: " + arr[index]);
                index++;
                turn = (turn + 1) % 3;
                condition.signalAll();
    		} catch(InterruptedException e) {
    			System.out.println(e.getStackTrace());
    			Thread.currentThread().interrupt();
    			return;
    		} finally {
    			lock.unlock();
    		}
    	}
    }

}
