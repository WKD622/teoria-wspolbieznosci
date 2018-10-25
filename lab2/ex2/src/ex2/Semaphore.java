package ex2;

import java.util.logging.Logger;

public class Semaphore implements ISemaphore {

	private boolean taken;
	Logger logger = Logger.getLogger(getClass().getName());

	public Semaphore() {
		this.taken = false;
	}

	@Override
	public synchronized void leave() {
		this.taken = false;
		notify();
		logger.info("Released " + Thread.currentThread().getName());
	}

	@Override
	public synchronized void take() {
		if (!canBeTaken()) {
			try {
				logger.info("Waiting " + Thread.currentThread().getName());
				wait();
			} catch (InterruptedException e) {
				// logger.info("SemaphoreBinary interrupted");
			}
		}
		this.taken = true;
		logger.info("Aqquired " + Thread.currentThread().getName());
	}

	@Override
	public boolean canBeTaken() {
		return !taken;
	}

}
