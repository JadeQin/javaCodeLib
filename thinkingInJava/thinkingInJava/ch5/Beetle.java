package thinkingInJava.ch5;

public class Beetle extends Insect {

	private static int x2 = printInt("static x2 init");
	private int k = printInt("Beetle.k initialized");

	public Beetle() {
		System.out.println("k=" + k);
		System.out.println("j=" + j);
	}

	public static void main(String[] a) {
		System.out.println("Beetle con");
		Beetle b = new Beetle();
	}
}

class Insect {

	private static int x1 = printInt("static Insect.x1 initialized");

	private int i = 9;
	protected int j;

	Insect() {
		System.out.println("i=" + i + ",j=" + j);
		j = 39;
	}

	static int printInt(String s) {
		System.out.println(s);
		return 47;
	}
}