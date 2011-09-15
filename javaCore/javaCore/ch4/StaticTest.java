package javaCore.ch4;

public class StaticTest {

	static {
		System.out.println(1);
	}
	{
		System.out.println(2);
	}

	public StaticTest() {
		System.out.println(3);
	}

	public static void tt() {
		System.out.println(4);
	}

	public static void main(String[] args) {
		StaticTest.tt();
	}
}
