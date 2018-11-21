Fpublic class Element {
	private Element nextElement;
	private Object object;
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
