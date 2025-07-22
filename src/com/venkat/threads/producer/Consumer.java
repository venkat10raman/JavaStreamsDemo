package com.venkat.threads.producer;

public class Consumer implements Runnable {
	
private final LockBlockQueue blockQueue;
	
	public Consumer(LockBlockQueue blockQueue) {
		this.blockQueue = blockQueue;
	}

	@Override
	public void run() {
		try {
            while (true) {
                blockQueue.consume();
                Thread.sleep(800); // simulate work
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
	}

}
