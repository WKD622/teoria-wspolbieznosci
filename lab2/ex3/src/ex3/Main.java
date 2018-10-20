package ex3;

public class Main {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(4);
		ListToOperate list = new ListToOperate();
		Add add1 = new Add(list, semaphore);
		Add add2 = new Add(list, semaphore);
		Add add3 = new Add(list, semaphore);
		Add add4 = new Add(list, semaphore);
		Remove remove1 = new Remove(list, semaphore);
		Remove remove2 = new Remove(list, semaphore);
		add1.start();
		add2.start();
		add3.start();
		add4.start();
		remove1.start();
		remove2.start();
	}
}
