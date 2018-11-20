package lab5_sem;

import java.util.concurrent.Semaphore;

public class Writer extends Thread {
	Semaphore wsem;

	public Writer(Semaphore wsem) {
		this.wsem = wsem;
	}

	public void run() {
		try {
			while (true) {
				wsem.acquire();
				Thread.sleep(100);
				System.out.println("Writing");
				wsem.release();
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
