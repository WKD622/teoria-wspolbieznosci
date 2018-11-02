package lab3;

public class Producer extends Thread {
	private Buffer _buf;

	public Producer(Buffer buffer) {
		this._buf = buffer;
	}

	public void run() {
		while(true) {
			_buf.put();
			System.out.println("Producer producing " + Thread.currentThread().getId());	
		}
	}
}
