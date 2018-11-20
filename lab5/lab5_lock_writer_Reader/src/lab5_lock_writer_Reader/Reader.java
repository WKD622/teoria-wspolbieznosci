package lab5_lock_writer_Reader;

import java.util.concurrent.locks.ReadWriteLock;

public class Reader extends Thread {
	ReadWriteLock lock;

	public Reader(ReadWriteLock lock) {
		this.lock = lock;
	}

	public void run() {
//		for (int i = 0; i < 3; i++) {
			lock.readLock().lock();
//			System.out.println("Reading " + Thread.currentThread().getName());
//			try {
//				//Thread.sleep(50);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			lock.readLock().unlock();
//		}
	}
}
