package lab3;

import java.util.LinkedList;

public class Buffer {
	ISemaphore semaphore;
	LinkedList<Object> buffer;
	int maxLength;

	public Buffer(int size, ISemaphore semaphore, int maxLength) {
		this.semaphore = semaphore;
		this.buffer = new LinkedList<>();
		this.maxLength = maxLength;
	}

	public void put(int i) {
		semaphore.take();
		buffer.add(new Object());
		semaphore.leave();
	}

	public void get() {
		semaphore.take();
		if (!buffer.isEmpty())
			buffer.removeFirst();
		semaphore.leave();
	}
}
