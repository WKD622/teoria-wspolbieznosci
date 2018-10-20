package ex3;

public class Add extends Thread {
	ListToOperate test;
	Semaphore semaphore;

	public Add(ListToOperate test, Semaphore semaphore) {
		System.out.println("created add " + Thread.currentThread().getId());
		this.test = test;
		this.semaphore = semaphore;
	}

	public void run() {
		synchronized (test) {
			for (int i = 0; i < 20; i++) {
				while (semaphore.canNotBeTaken()) {
					try {
						System.out.println("waiting for adding" + Thread.currentThread().getName());
						test.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				semaphore.take();
				test.add();
				test.notifyAll();
				System.out.println(Thread.currentThread().getName() + "  sem: " + semaphore + " list: " + test);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				semaphore.leave();
			}
		}
	}
}