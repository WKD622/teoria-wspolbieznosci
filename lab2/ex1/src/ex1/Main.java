package ex1;

public class Main {

	public static void main(String[] args) {

		for (int a = 0; a < 500; a++) {
			I i = new I();
			Increment increment = new Increment(i);
			Decrement decrement = new Decrement(i);
			increment.start();
			decrement.start();
			System.out.println(i.i);
		}
	}

}
