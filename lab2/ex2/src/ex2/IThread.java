package ex2;

public class IThread extends Thread {
	private Counter _cnt;
	private ISemaphore sem;

	public IThread(Counter c, ISemaphore sem) {
		_cnt = c;
		this.sem = sem;
	}

	public void run() {
		for (int i = 0; i < 1000; ++i) {
			sem.take();
			_cnt.inc();
			sem.leave();
			// try { this.sleep(50); }
			// catch(Exception e) {}
		}
	}
}
