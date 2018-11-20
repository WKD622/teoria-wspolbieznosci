package lab5_locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		int numberOfWriters = 10;
		int numberOfReaders = 10;
		Lock lock = new ReentrantLock();
		Condition writerIsWriting = lock.newCondition();
		Condition moreReaders = lock.newCondition();
		List<Writer> writers = new ArrayList<>();
		List<Reader> readers = new ArrayList<>();

		for (int i = 0; i < numberOfReaders; i++) {
			readers.add(new Reader(lock, writerIsWriting, moreReaders));
		}

		for (int i = 0; i < numberOfWriters; i++) {
			writers.add(new Writer(lock, writerIsWriting));
		}

		for (Reader reader : readers) {
			reader.run();
		}

		for (Writer writer : writers) {
			writer.run();
		}
	}

}
