package lab3;

public class Semaphore implements ISemaphore {

	private boolean taken;

	public Semaphore() {
		taken = false;
	}

	@Override
	public synchronized void take() {
		while(!canBeTaken()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		taken = true;
	}

	@Override
	public synchronized void leave() {
		taken = false;
		notifyAll();
	}

	@Override
	public boolean canBeTaken() {
		return !taken;
	}

}
