package ex2;

class DThread extends Thread {
	private Counter _cnt;
	private ISemaphore sem;
	private int numberOfLoops;

	public DThread(Counter c, ISemaphore sem, int numberOfLoops) {
		_cnt = c;
		this.sem = sem;
		this.numberOfLoops = numberOfLoops;
	}

	public void run() {
		for (int i = 0; i < numberOfLoops; ++i) {
			sem.take();
			_cnt.dec();
			//System.out.println(_cnt.value());
			sem.leave();
		}
	}
}
