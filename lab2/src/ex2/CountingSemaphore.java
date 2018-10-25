package ex2;

public class CountingSemaphore implements ISemaphore {

	private int value;

	public CountingSemaphore(int semaphoreValue) {
		this.value = semaphoreValue;
	}

	@Override
	public void leave() {
		this.value++;
		notifyAll();
	}

	@Override
	public void take() {
		while (!canBeTaken())
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.value--;
	}

	@Override
	public boolean canBeTaken() {
		return this.value > 0;
	}

}
