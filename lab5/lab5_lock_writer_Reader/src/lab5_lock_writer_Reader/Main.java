package lab5_lock_writer_Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

	public static void main(String[] args) {
		ReadWriteLock lock = new ReentrantReadWriteLock();

		int numberOfWriters = 5;
		int numberOfReaders = 5;
		List<Thread> threadsW = new ArrayList<>();

		List<Thread> threadsR = new ArrayList<>();

		for (int i = 0; i < numberOfReaders; i++) {
			threadsW.add(new Thread(new Reader(lock)));
		}

		for (int i = 0; i < numberOfWriters; i++) {
			threadsR.add(new Thread(new Writer(lock)));
		}

		for (Thread writer : threadsW)
			writer.start();

		for (Thread reader : threadsR)
			reader.start();

	}

}
