package ex2;

public class Add extends Thread {
	ListToOperate test;

	public Add(ListToOperate test) {
		this.test = test;
	}

	public void run() {
		synchronized (test) {
			for (int i = 0; i < 20; i++) {
				while (test.removingTime == true) {
					try {
						test.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				test.add();
				if (test.isFull()) {
					test.addingTime = false;
					test.removingTime = true;
				}
				test.notifyAll();
				System.out.println(i + ") length: " + test);
			}
		}
	}
}