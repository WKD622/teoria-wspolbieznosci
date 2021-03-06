
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ElementList {
	Element firstElement;
	Random rand = new Random();
	private Lock lock = new ReentrantLock();

	public ElementList() {
		this.firstElement = null;
	}

	public boolean contains(Object o) {
		lock.lock();
		Element element = firstElement;
		if (element != null) {
			while (element.getNextElement() != null) {
				if (element.getObject() == o) {
					lock.unlock();
					return true;
				}
				element = element.getNextElement();
			}
			lock.unlock();
			return false;

		} else {
			lock.unlock();
			return false;
		}
	}

	public boolean remove(Object o) {
		lock.lock();
		Element element = firstElement;
		if (element != null) {
			if (element.getObject() == o) {
				if (element.getNextElement() != null) {
					this.firstElement = element.getNextElement();
				} else
					this.firstElement = null;
				lock.unlock();
				return true;
			}
			Element nextElement = firstElement.getNextElement();
			if (nextElement != null) {
				while (nextElement.getNextElement() != null) {
					if (nextElement.getObject() == o) {
						element.setNextElement(nextElement.getNextElement());
						lock.unlock();
						return true;
					}
					element = nextElement;
					nextElement = nextElement.getNextElement();
				}
				if (nextElement.getObject() == o) {
					element.setNextElement(null);
					lock.unlock();
					return true;
				}
				lock.unlock();
				return false;
			}
		}
		return false;
	}

	public boolean add(Object o) {
		lock.lock();
		if (firstElement == null) {
			firstElement = new Element(o, rand.nextInt(50));
			lock.unlock();
			return true;
		} else {
			Element end = goToTheEnd();
			Element newElement = new Element(o, rand.nextInt(50));
			end.setNextElement(newElement);
			lock.unlock();
			return true;
		}
	}

	private Element goToTheEnd() {
		lock.lock();
		Element element = firstElement;
		while (element.getNextElement() != null) {
			element = element.getNextElement();
		}
		lock.unlock();
		return element;
	}

	public void print() {
		Element element = firstElement;
		if (element == null) {
			System.out.println("null");
			return;
		}
		while (element.getNextElement() != null) {
			System.out.print(element.toString() + " -> ");
			element = element.getNextElement();
		}
		System.out.println(element.toString());
	}
}
