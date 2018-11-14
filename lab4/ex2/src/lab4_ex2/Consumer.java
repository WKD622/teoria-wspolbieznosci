package lab4_ex2;

import java.util.Random;

public class Consumer implements Runnable {
	private Buffer _buf;

	public Consumer(Buffer buffer) {
		this._buf = buffer;
	}

	public void run() {
		while (true) {
			Random rand = new Random();
			int randomNumber = rand.nextInt(5) + 1;
			try {
				_buf.remove(randomNumber);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Consumer " + Thread.currentThread().getId() + " eating " + randomNumber);
		}
	}
}