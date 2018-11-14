package lab4_ex2;

import java.util.ArrayList;
import java.util.List;

public class PKmon {
	public static void main(String[] args) {
		int numberOfConsumers = 5;
		int numberOfProducers = 6;
		Buffer buffer = new Buffer(2 * numberOfProducers);

		List<Thread> threadsP = new ArrayList<>();
		for (int i = 0; i < numberOfProducers; i++) {
			threadsP.add(new Thread(new Producer(buffer)));
		}

		List<Thread> threadsC = new ArrayList<>();
		for (int i = 0; i < numberOfConsumers; i++) {
			threadsC.add(new Thread(new Consumer(buffer)));
		}

		for (Thread consumer : threadsC)
			consumer.start();

		for (Thread producer : threadsP)
			producer.run();

	}
}
