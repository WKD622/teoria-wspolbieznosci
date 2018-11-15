package lab4_ex2;

import java.util.Random;

public class Consumer implements Runnable {
	private Buffer _buf;
	private int max_rand;

	public Consumer(Buffer buffer, int max_rand) {
		this._buf = buffer;
		this.max_rand = max_rand;
	}

	public void run() {
		while (true) {
//			System.out.println("consumer");
			Random rand = new Random();
			int randomNumber = rand.nextInt(max_rand) + 1;
			try {
				_buf.remove(randomNumber);
				Stats.liczbaWywolanConsumenta++;
				System.out.println("consumer" + Stats.liczbaWywolanConsumenta);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("Consumer " + Thread.currentThread().getId() + " eating " + randomNumber);
		}
	}
}