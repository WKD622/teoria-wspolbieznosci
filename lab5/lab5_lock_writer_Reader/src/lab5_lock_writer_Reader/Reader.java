package lab5_lock_writer_Reader;

import java.util.concurrent.locks.ReadWriteLock;

public class Reader extends Thread {
	ReadWriteLock lock;

	public Reader(ReadWriteLock lock) {
		this.lock = lock;
	}

	public void run() {
		lock.readLock().unlock();
		System.out.println("Writing");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock.readLock().lock();
	}
}
