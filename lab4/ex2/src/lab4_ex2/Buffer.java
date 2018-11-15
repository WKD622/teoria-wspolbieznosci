package lab4_ex2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	LinkedList<Object> buffer;
	int maxLength;
	private final Lock lock = new ReentrantLock();
	private final Condition notEnoughtEmpty = lock.newCondition();
	private final Condition notEnoughtFull = lock.newCondition();

	public Buffer(int maxLength) {
		this.maxLength = maxLength;
		this.buffer = new LinkedList<>();
	}

	public void add(int numberToAdd) throws InterruptedException {
		lock.lock();
		try {
			while (buffer.size() >= maxLength - numberToAdd) {
				notEnoughtEmpty.await();
			}
			for (int i = 0; i < numberToAdd; i++)
				buffer.add(new Object());

			notEnoughtFull.signal();
		} finally {
			lock.unlock();
		}
	}

	public void remove(int numberToRemove) throws InterruptedException {
		lock.lock();

		try {
			while (buffer.size() - numberToRemove < 0) {
				notEnoughtFull.await();
			}

			for (int i = 0; i < numberToRemove; i++)
				buffer.removeFirst();

			notEnoughtEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

}
