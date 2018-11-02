package ex1;

import java.util.LinkedList;

public class Buffer {
	LinkedList<Object> buffer;
	int maxLength;

	public Buffer(int maxLength) {
		this.buffer = new LinkedList<>();
		this.maxLength = maxLength;
	}

	public void put() {
		if (buffer.size() < maxLength) 
			buffer.add(new Object());
	}		

	public void get() {
		if (!buffer.isEmpty())
			buffer.removeFirst();	
	}
}	
