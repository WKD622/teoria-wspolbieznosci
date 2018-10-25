package lab3;

public class Consumer {
	private Buffer _buf;
	ISemaphore semaphore;

	public Consumer(ISemaphore semaphore, Buffer buffer) {
		this.semaphore = semaphore;
		this._buf = buffer;
	}

	public void run() {
		for (int i = 0; i < 100; ++i) {
			semaphore.take();
			_buf.get();
			semaphore.leave();
		}
	}
}
