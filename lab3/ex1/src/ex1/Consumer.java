package ex1;

public class Consumer extends Thread {
	private Buffer _buf;

	public Consumer(Buffer buffer) {
		this._buf = buffer;
	}

	public synchronized void run() {
		while(true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			_buf.get();
			System.out.println("Consumer eating " + Thread.currentThread().getId());
			notify();
		}
	}
}
