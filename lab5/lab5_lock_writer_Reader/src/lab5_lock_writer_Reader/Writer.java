package lab5_lock_writer_Reader;

import java.util.concurrent.locks.ReadWriteLock;

public class Writer extends Thread {
	ReadWriteLock lock;

	public Writer(ReadWriteLock lock) {
		this.lock = lock;
	}

	public void run() {
//		for (int i = 0; i < 3; i++) {
			lock.writeLock().lock();
//			System.out.println("Writing");
//			try {
//				//Thread.sleep(50);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			lock.writeLock().unlock();
//		}
	}
}
