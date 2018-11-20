package lab5_list;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		List<Object> objects = new ArrayList<>();
		int numberOfOperations = 1000;
		try {
			PrintWriter results = new PrintWriter("results.txt", "UTF-8");

			ElementList elementList = new ElementList();

			long startTime = System.nanoTime();

			for (int i = 0; i < numberOfOperations; i++) {
				int option = rand.nextInt(4);
				Object o;
				switch (option) {
				case 0:
					o = new Object();
					objects.add(o);
					elementList.add(o);
					break;
				case 1:
					if (objects.size() > 0) {
						o = objects.get(rand.nextInt(objects.size()));
						elementList.contains(o);
					}
					break;
				case 2:
					if (objects.size() > 0) {
						o = objects.get(rand.nextInt(objects.size()));
						elementList.remove(o);
					}
					break;
				case 3:
					o = new Object();
					objects.add(o);
					elementList.add(o);
					break;
				default:
					break;
				}
			}
			long stopTime = System.nanoTime();
			results.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
