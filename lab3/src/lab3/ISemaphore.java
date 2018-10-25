package lab3;

public interface ISemaphore {

	void take();

	void leave();

	boolean canBeTaken();
}
