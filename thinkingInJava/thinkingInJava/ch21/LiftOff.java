package thinkingInJava.ch21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOff extends Thread {

	private static int taskCount = 0;

	private int countDown = 5;
	private int id = taskCount++;

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!")
				+ "), ";
	}

	public void run() {
		while (countDown-- > 0) {
			System.out.println(status() + getName());
			// Thread.yield();
		}
	}

	public static void main(String[] args) {
		// new LiftOff().start();
		// new LiftOff().start();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new LiftOff());
	}
}
