package lab5_locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Reader {
	private final Lock lock;
	private final Condition writerIsWriting;
	private final Condition moreReaders;
	public static boolean readersTime;

	public Reader(Lock lock, Condition writerIsWriting, Condition moreReaders) {
		this.lock = lock;
		this.writerIsWriting = writerIsWriting;
		this.moreReaders = moreReaders;
		this.readersTime = false;
	}

	public void run() {
		while (true) {
			lock.lock();
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
