package lab4_ex2;

import java.util.Random;

public class Producer implements Runnable {
	private Buffer _buf;
	private int max_rand;

	public Producer(Buffer buffer, int maxRand) {
		this._buf = buffer;
		this.max_rand = maxRand;
	}

	public void run() {

		while (true) {
			// System.out.println("producer1");
			Random rand = new Random();
			int randomNumber = rand.nextInt(max_rand) + 1;
			try {
				// System.out.println("producer2");
				_buf.add(randomNumber);
				Stats.liczbaWywolanProducera++;
				System.out.println("Producer" + Stats.liczbaWywolanProducera);
				// System.out.println("producer3");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("Producer " + Thread.currentThread().getId() + " producing " + randomNumber);
		}
	}
}
