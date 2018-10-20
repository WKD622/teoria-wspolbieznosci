package ex1;

public class Increment extends Thread {
	I i;

	public Increment(I i) {
		this.i = i;
	}

	public void run() {
		for (int a = 0; a < 1000000; a++) {
			synchronized (i) {
				try {
					i.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i.i++;
				notify();
			}
		}
	}
}
