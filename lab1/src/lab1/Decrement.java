
package lab1;

public class Decrement extends Thread {
	public void run() {
		for (int a = 0; a < 10000000; a++)
			Main.i--;
	}
}