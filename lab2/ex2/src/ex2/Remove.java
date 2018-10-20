package ex2;

public class Remove extends Thread {
	ListToOperate test;

	public Remove(ListToOperate test) {
		this.test = test;
	}

	public void run() {
		synchronized (test) {
			for (int i = 0; i < 20; i++) {
				while (test.addingTime == true) {
					try {
						test.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				test.remove();
				if (test.isEmpty()) {
					test.addingTime = true;
					test.removingTime = false;
				}
				test.notifyAll();
				System.out.println(i + ") length: " + test);
			}
		}
	}
}