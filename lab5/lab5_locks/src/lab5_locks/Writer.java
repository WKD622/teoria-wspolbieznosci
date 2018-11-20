package lab5_locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Writer {
	private final Lock lock;
	private final Condition writerIsWriting;
	public static boolean isWriting = false;

	public Writer(Lock lock, Condition writerIsWriting) {
		this.lock = lock;
		this.writerIsWriting = writerIsWriting;
	}

	public void run() {
		while (true) {
			try {
				while (Writer.isWriting == true) {
					writerIsWriting.await();
				}
				Writer.isWriting = true;
				System.out.println("Writing");
				Writer.isWriting = false;
				writerIsWriting.signal();
			} catch (InterruptedException e) {
				return;
			} finally {
				lock.unlock();
			}

		}
	}
}
