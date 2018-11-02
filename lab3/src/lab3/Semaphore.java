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
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void leave() {
		taken = false;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notifyAll();	
	}

	@Override
	public boolean canBeTaken() {
		return !taken;
	}

}
