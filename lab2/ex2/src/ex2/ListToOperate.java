package ex2;

import java.util.ArrayList;
import java.util.List;

public class ListToOperate {
	List<Object> test;
	boolean addingTime = true;
	boolean removingTime = false;

	public ListToOperate() {
		test = new ArrayList<>();
	}

	public void add() {
		test.add(new Object());
	}
	
	public void remove() {
		test.remove(test.size()-1);
	}

	public boolean isEmpty() {
		return test.isEmpty();
	}

	public boolean isFull() {
		if (test.size() == 10) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return Integer.toString(test.size());
	}
}
