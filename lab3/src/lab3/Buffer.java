package lab3;

import java.util.LinkedList;

public class Buffer {
	ISemaphore semaphore;
	LinkedList<Object> buffer;
	int maxLength;

	public Buffer(ISemaphore semaphore, int maxLength) {
		this.semaphore = semaphore;
		this.buffer = new LinkedList<>();
		this.maxLength = maxLength;
	}

	public void put() {
		semaphore.take();
		if (buffer.size() < maxLength) 
			buffer.add(new Object());
		else 
			System.out.println("Full buffer");
		semaphore.leave();
	}		

	public void get() {
		semaphore.take();
		if (!buffer.isEmpty())
			buffer.removeFirst();
		else 
			System.out.println("Empty buffer");
		semaphore.leave();
	}
}
