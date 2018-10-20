package ex3;

public class Semaphore {
	private int actualValue;
	
	public void leave() {
		System.out.println("leaving sem " + Thread.currentThread().getName());
		this.actualValue++;
	}
	
	public void take() {
		System.out.println("taking sem " + Thread.currentThread().getName());
		this.actualValue--;
	}
	
	public int getValue() {
		return actualValue;
	}
	
	public boolean canNotBeTaken(){
		return (actualValue == 0);
					
	}
	public Semaphore(int value) {
		this.actualValue = value;
	}
	
	@Override
	public String toString() {
		return Integer.toString(actualValue);
	}
	
}
