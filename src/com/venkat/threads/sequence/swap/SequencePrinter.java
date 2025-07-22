package com.venkat.threads.sequence.swap;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SequencePrinter {
	
	private Lock lock = new ReentrantLock();
	private Condition evenCondition = lock.newCondition();
	private Condition oddCondition = lock.newCondition();
//	private int evenCount = 2;
//	private int oddCount = 1;
	private int count = 1;
	private boolean isOdd = true;
	
	
	public void printEven() {
		while(count < 10) {
			lock.lock();
			try {
				while(isOdd) {
					evenCondition.await();
				}
				System.out.println(Thread.currentThread().getName() + " -> " + count);
//				evenCount = evenCount %2 == 0 ? evenCount+1 : evenCount+3;
				count = count + 2;
				isOdd = true;
				oddCondition.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
	
	public void printOdd(){
		while(count < 10) {
			lock.lock();
			try {
				while(!isOdd) {
					oddCondition.await();
				}
				System.out.println(Thread.currentThread().getName() + " -> " + count);
//				oddCount = oddCount%2 == 1 ? oddCount+3 : oddCount+1;
				count = count % 2 == 1 ? count+1 : count-1;
				isOdd = false;
				evenCondition.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		SequencePrinter sq = new SequencePrinter();
		Thread t1 = new Thread(() -> sq.printOdd(), "T1");
		Thread t2 = new Thread(() -> sq.printEven(), "T2");
		t1.start();
		t2.start();
	}

}
