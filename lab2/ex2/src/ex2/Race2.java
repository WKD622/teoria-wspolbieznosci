package ex2;

class Race2 {
	public static void main(String[] args) {
		int numberOfLoops = 1000000;
		ISemaphore sem = new SemaphoreWithWhile();
		Counter cnt = new Counter(0);
		IThread it1 = new IThread(cnt, sem, numberOfLoops);
		IThread it2 = new IThread(cnt, sem, numberOfLoops);
		DThread dt1 = new DThread(cnt, sem, numberOfLoops);
		DThread dt2 = new DThread(cnt, sem, numberOfLoops);

		it1.start();
		it2.start();
		dt1.start();
		dt2.start();

		try {
			it1.join();
			dt1.join();
			it2.join();
			dt2.join();
		} catch (InterruptedException ie) {
		}

		System.out.println("value=" + cnt.value());
	}
}