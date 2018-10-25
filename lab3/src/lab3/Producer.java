package lab3;

public class Producer extends Thread {
	private Buffer _buf;
	private ISemaphore semaphore;

	public Producer(ISemaphore semaphore, Buffer buffer) {
		this.semaphore = semaphore;
		this._buf = buffer;
	}

	public void run() {
		for (int i = 0; i < 100; ++i) {
			semaphore.take();
			_buf.put(i);
			semaphore.leave();
		}
	}
}
