package lab5_sem;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore wsem = new Semaphore(1, true);
		Semaphore x = new Semaphore(1);

		Thread writer1 = new Thread(new Writer(wsem));
		Thread writer2 = new Thread(new Writer(wsem));
		Thread reader1 = new Thread(new Reader(wsem, x));
		Thread reader2 = new Thread(new Reader(wsem, x));
		Thread reader3 = new Thread(new Reader(wsem, x));

		Reader.readCount = 0;
		writer1.start();
		reader1.start();
		reader2.start();
		writer2.start();
		reader3.start();
	}
}
