package lab3;

public class PKmon {
	public static void main(String[] args) {
		ISemaphore semaphore = new Semaphore();
		Buffer buffer = new Buffer(semaphore, 10);

		Producer producer = new Producer(buffer);
		Consumer consumer1 = new Consumer(buffer);
		Consumer consumer2 = new Consumer(buffer);
		
		producer.start();
		consumer1.start();
		consumer2.start();
		
	}
}
