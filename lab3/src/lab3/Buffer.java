package lab3;

import java.util.LinkedList;

public class Buffer {
	LinkedList<Object> buffer;

	public Buffer(int size) {
		this.buffer = new LinkedList<>();
	}

	public void put(int i) {
		buffer.add(new Object());
	}

	public Object get() {
		return buffer.removeFirst();
	}
}
