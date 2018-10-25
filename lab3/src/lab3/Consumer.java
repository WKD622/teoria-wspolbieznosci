package lab3;

public class Consumer {
	private Buffer _buf;

	public void run() {
		for (int i = 0; i < 100; ++i) {
			System.out.println(_buf.get());
		}
	}
}
