package lab3;

public class Consumer extends Thread {
	private Buffer _buf;

	public Consumer(Buffer buffer) {
		this._buf = buffer;
	}

	public void run() {
		while(true) {
			_buf.get();
			System.out.println("Consumer eating " + Thread.currentThread().getId());
		}
	}
}
