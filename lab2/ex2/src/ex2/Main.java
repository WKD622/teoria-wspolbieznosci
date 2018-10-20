package ex2;

public class Main {

	public static void main(String[] args) {
		ListToOperate list = new ListToOperate();
		Add add1 = new Add(list);
		Add add2 = new Add(list);
		Remove remove1 = new Remove(list);
		Remove remove2 = new Remove(list);
		add1.start();
		add2.start();
		remove1.start();
		remove2.start();
	}
}
