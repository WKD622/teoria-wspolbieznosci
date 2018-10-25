package lab3;

public class Producer extends Thread {
	private Buffer _buf;

	public void run() {
		for (int i = 0; i < 100; ++i) {
			_buf.put(i);
		}
	}
}
