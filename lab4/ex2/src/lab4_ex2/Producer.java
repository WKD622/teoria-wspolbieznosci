package lab4_ex2;

import java.util.Random;

public class Producer implements Runnable {
	private Buffer _buf;

	public Producer(Buffer buffer) {
		this._buf = buffer;
	}

	public void run() {
		while (true) {
			Random rand = new Random();
			int randomNumber = rand.nextInt(5) + 1;
			try {
				_buf.add(randomNumber);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Producer " + Thread.currentThread().getId() + " producing " + randomNumber);
		}
	}
}
