package lab5_list;

import java.util.Random;

public class ElementList {
	Element firstElement;
	Random rand = new Random();

	public ElementList() {
		this.firstElement = null;
	}

	public boolean contains(Object o) {
		Element element = firstElement;
		if (element != null) {
			element.lock();
			while (element.getNextElement() != null) {
				Element lastElement = element;
				if (element.getObject() == o)
					return true;
				lastElement.unlock();
				element = element.getNextElement();
				element.lock();
			}
			element.unlock();
			return false;
		} else
			return false;
	}

	@SuppressWarnings("unused")
	public boolean remove(Object o) {
		Element element = firstElement;
		if (element != null) {
			element.lock();
			if (element.getObject() == o) {
				if (element.getNextElement() != null) {
					this.firstElement = element.getNextElement();
					element.unlock();
				}
				else
					this.firstElement = null;
				return true;
			}
			Element nextElement = firstElement.getNextElement();
			if (nextElement != null) {
				nextElement.lock();
				while (nextElement.getNextElement() != null) {
					if (nextElement.getObject() == o) {
						element.setNextElement(nextElement.getNextElement());
						return true;
					}
					element.unlock();
					element = nextElement;
					nextElement = nextElement.getNextElement();
					nextElement.lock();
				}
				element.unlock();
				nextElement.unlock();
				if (nextElement.getObject() == o) {
					element.setNextElement(null);
					return true;
				}
				return false;
			}
		}
		return false;
	}

	public boolean add(Object o) {
		if (firstElement == null) {
			firstElement = new Element(o, rand.nextInt(50));
			return true;
		} else {
			Element end = goToTheEnd();
			Element newElement = new Element(o, rand.nextInt(50));
			end.setNextElement(newElement);
			return true;
		}
	}

	private Element goToTheEnd() {
		Element element = firstElement;
		element.lock();
		while (element.getNextElement() != null) {
			Element lastElement = element;
			lastElement.unlock();
			element = element.getNextElement();
			element.lock();
		}
		element.unlock();
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
