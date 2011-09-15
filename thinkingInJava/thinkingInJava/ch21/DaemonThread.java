package thinkingInJava.ch21;

import java.util.concurrent.TimeUnit;

public class DaemonThread extends Thread {

	public void run() {
		System.out.println("start");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("end");
		}
	}

	public static void main(String[] args) {
		Thread damon = new Thread(new DaemonThread());
		// damon.setDaemon(true);
		damon.start();
	}
}
