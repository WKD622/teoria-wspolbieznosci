package lab4;

import java.util.ArrayList;
import java.util.List;

public class PKmon {
	public static void main(String[] args) {
		int numberOfConsumers = 5;
		int numberOfProducers = 6;
		Buffer buffer = new Buffer(2 * numberOfProducers);
		List<Producer> producers = new ArrayList<>();
		for (int i = 0; i < numberOfProducers; i++)
			producers.add(new Producer(buffer));

		List<Consumer> consumers = new ArrayList<>();
		for (int i = 0; i < numberOfConsumers; i++)
			consumers.add(new Consumer(buffer));

		for (Consumer consumer : consumers)
			consumer.start();

		for (Producer producer : producers)
			producer.start();

	}
}
