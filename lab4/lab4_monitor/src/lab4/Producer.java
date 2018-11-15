package lab4;

import java.util.Random;

public class Producer extends Thread {
	private Buffer _buf;

	public Producer(Buffer buffer) {
		this._buf = buffer;
	}

	public synchronized void run() {
		while (true) {
			try {
				if (!_buf.canBeTaken())
					wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Random rand = new Random();
			for (int i = 0; i < rand.nextInt(5); i++)
				_buf.put();
			Stats.liczbaWywolanProducera++;
			System.out.println("Producer" + Stats.liczbaWywolanProducera);
			System.out.println("Producer producing " + Thread.currentThread().getId());
			// try {
			// Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			notify();
		}
	}
}
