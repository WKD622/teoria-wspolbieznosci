package ex1;

public class Producer extends Thread {
	private Buffer _buf;

	public Producer(Buffer buffer) {
		this._buf = buffer;
	}

	public synchronized void run() {
		while (true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			_buf.put();
			System.out.println("Producer producing " + Thread.currentThread().getId());
			notify();
		}
	}
}
