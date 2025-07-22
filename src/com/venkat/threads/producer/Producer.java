package com.venkat.threads.producer;

public class Producer implements Runnable {
	
	private final LockBlockQueue blockQueue;
	
	public Producer(LockBlockQueue blockQueue) {
		this.blockQueue = blockQueue;
	}

	@Override
	public void run() {
		int value = 0;
		try {
            while (true) {
            	blockQueue.produce(Integer.toString(value++));
                Thread.sleep(500); // simulate work
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
	}

}
