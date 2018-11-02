package ex1;

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
			_buf.put();
			System.out.println("Producer producing " + Thread.currentThread().getId());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notify();
		}
	}
}
