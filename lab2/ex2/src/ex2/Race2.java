package ex2;

class Race2 {
	public static void main(String[] args) {
		ISemaphore sem = new Semaphore();
		Counter cnt = new Counter(0);
		IThread it = new IThread(cnt, sem);
		DThread dt = new DThread(cnt, sem);

		it.start();
		dt.start();

		try {
			it.join();
			dt.join();
		} catch (InterruptedException ie) {
		}

		System.out.println("value=" + cnt.value());
	}
}