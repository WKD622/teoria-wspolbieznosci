package lab5_list;

public class SingleOperation implements Runnable {
	private ElementList elementList;

	public SingleOperation(ElementList elementList) {
		this.elementList = elementList;
	}

	@Override
	public void run() {
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		Object o4 = new Object();
		Object o5 = new Object();

		elementList.add(o1);
		elementList.add(o2);
		elementList.add(o3);

		elementList.contains(o1);
		elementList.contains(o2);
		elementList.contains(o4);

		elementList.add(o4);
		elementList.add(o5);

		elementList.remove(o1);
		elementList.remove(o2);
		elementList.remove(o3);
		elementList.remove(o4);
		elementList.remove(o5);
	}
}
