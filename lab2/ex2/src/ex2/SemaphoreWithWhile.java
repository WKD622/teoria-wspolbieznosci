package ex2;

import java.util.logging.Logger;

public class SemaphoreWithWhile implements ISemaphore {

	private boolean taken;
	Logger logger = Logger.getLogger(getClass().getName());

	public SemaphoreWithWhile() {
		this.taken = false;
	}

	@Override
	public synchronized void leave() {
		this.taken = false;
		notifyAll();
//		logger.info("Released");
	}

	@Override
	public synchronized void take() {
		while (!canBeTaken()) {
			try {
//				logger.info("Waiting");
				wait();
			} catch (InterruptedException e) {
//				logger.info("SemaphoreBinary interrupted");
			}
		}
		this.taken = true;
//		logger.info("Aqquired");
	}

	@Override
	public boolean canBeTaken() {
		return !taken;
	}

}
