package ex2;

class DThread extends Thread {
	private Counter _cnt;
	private ISemaphore sem;

	public DThread(Counter c, ISemaphore sem) {
		_cnt = c;
		this.sem = sem;
	}

	public void run() {
		for (int i = 0; i < 1000; ++i) {
			sem.take();
			_cnt.dec();
			sem.leave();
			// try { this.sleep(1); }
			// catch(Exception e) {}
		}
	}
}
