package lab5_sem;

import java.util.concurrent.Semaphore;

public class Reader extends Thread {
	private Semaphore wsem;
	private Semaphore x;
	public static int readCount;

	public Reader(Semaphore wsem, Semaphore x) {
		this.x = x;
		this.wsem = wsem;
	}

	public void run() {
		try {
			while (true) {
				x.acquire();
				Reader.readCount++;
				if (Reader.readCount == 1)
					wsem.acquire();
				x.release();
				System.out.println("Reading");
				Thread.sleep(100);
				x.acquire();
				Reader.readCount--;
				if (Reader.readCount == 0)
					wsem.release();
				x.release();
			}
		} catch (InterruptedException e) {
			return;
		}
	}
}
