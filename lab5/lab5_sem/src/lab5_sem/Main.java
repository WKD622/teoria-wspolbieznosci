package lab5_sem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Semaphore wsem = new Semaphore(1, true);
		Semaphore x = new Semaphore(1);
		Reader.readCount = 0;
		
		Random rand = new Random();
		try {
			PrintWriter results = new PrintWriter("results.txt", "UTF-8");

			for (int j = 0; j < 1000; j++) {
				int numberOfReaders = rand.nextInt(100) + 10;
				int numberOfWriters = rand.nextInt(10) + 1;

				List<Thread> writers = new ArrayList<>();
				List<Thread> readers = new ArrayList<>();

				for (int i = 0; i < numberOfWriters; i++) {
					writers.add(new Thread(new Writer(wsem)));
				}

				for (int i = 0; i < numberOfReaders; i++) {
					readers.add(new Thread(new Reader(wsem, x)));
				}

				long startTime = System.nanoTime();

				for (int i = 0; i < numberOfWriters; i++) {
					readers.get(i).start();
					writers.get(i).start();

					readers.get(i).join();
					writers.get(i).join();
				}

				for (int i = numberOfWriters; i < numberOfReaders; i++) {
					readers.get(i).start();
					readers.get(i).join();
				}

				long stopTime = System.nanoTime();
				results.print(numberOfReaders + numberOfWriters);
				results.print("     ");
				results.println(TimeUnit.SECONDS.convert(stopTime - startTime, TimeUnit.MILLISECONDS));
			}
			results.close();
			Runtime.getRuntime().exec("gnuplot --persist -e 'plot \"results.txt\" u 1:2'\n");

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
