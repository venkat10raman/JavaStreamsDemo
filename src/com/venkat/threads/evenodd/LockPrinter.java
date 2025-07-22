package com.venkat.threads.evenodd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPrinter {

	private final int[] array;
	private int index = 0;
	private final Lock lock = new ReentrantLock();
	private final Condition evenCondition = lock.newCondition();
	private final Condition oddCondition = lock.newCondition();


	public LockPrinter(int[] array) {
		this.array = array;
	}

	public void printEven() {
		while(true) {
			lock.lock();
			try {
				while(index < array.length && array[index] % 2 == 1) {
					evenCondition.await();
				}

				if(index >= array.length) {
					// Wake up the other thread if waiting
					oddCondition.signal();
					break;
				}
				System.out.println(Thread.currentThread().getName() + " (Even): " + array[index]);
				index++;
				// Let odd thread proceed
				oddCondition.signal(); 

			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			} finally {
				lock.unlock();
			}
		}
	}
	
	public void printOdd() {
		while(true) {
			lock.lock();
			try {
				while(index < array.length && array[index] % 2 == 0) {
					oddCondition.await();
				}

				if(index >= array.length) {
					// Wake up the other thread if waiting
					evenCondition.signal();
					break;
				}
				
				System.out.println(Thread.currentThread().getName() + " (Even): " + array[index]);
				index++;
				// Let odd thread proceed
				evenCondition.signal(); 
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			} finally {
				lock.unlock();
			}
		}
	}

}
