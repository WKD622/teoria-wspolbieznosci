package lab5_list;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Element {
	private Element nextElement;
	private Object object;
	private Lock lock = new ReentrantLock();
	private int value;

	public Element(Object object, int value) {
		this.object = object;
		this.nextElement = null;
		this.value = value;
	}

	public void setNextElement(Element nextElement) {
		this.nextElement = nextElement;
	}

	public Object getObject() {
		return object;
	}

	public void lock() {
		this.lock.lock();
	}
	
	public void unlock() {
		this.lock.unlock();
	}

	public int getValue() {
		return value;
	}

	public Element getNextElement() {
		return nextElement;
	}
	
	@Override
	public String toString() {
		return Integer.toString(this.value);
	}
}
