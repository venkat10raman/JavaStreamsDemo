package com.venkat.threads.producer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBlockQueue {

	private final Queue<String> queue = new LinkedList<>();
	private int capacity;

	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	public LockBlockQueue(int capacity) {
		this.capacity = capacity;
	}

	public void produce(String item) {
		lock.lock();
		try {
			while(queue.size() == capacity) {
				notFull.await();
			}
			queue.add(item);
			System.out.println(Thread.currentThread().getName() + " Produced: " + item);
			notEmpty.signalAll();
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public String consume() {
		lock.lock();
		String item = null;
		try {
			while(queue.isEmpty()) {
				notEmpty.await();
			}
			item = queue.poll();
			System.out.println(Thread.currentThread().getName() + " Consumed: " + item);
			notFull.signalAll();
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return item;
	}



}
