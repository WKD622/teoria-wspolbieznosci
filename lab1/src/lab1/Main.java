package lab1;

public class Main {
	public static int i = 0;

	public static void main(String[] args) {
		for (int a = 0; a < 10000; a++) {
			i = 0;
			Increment increment = new Increment();
			Decrement decrement = new Decrement();
			increment.setPriority(10);
			decrement.setPriority(10);
			increment.start();
			decrement.start();
			try {
				increment.join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				decrement.join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(i);
		}
	}
}