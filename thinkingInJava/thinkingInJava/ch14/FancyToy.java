package thinkingInJava.ch14;

public class FancyToy extends Toy implements I1, I2, I3 {

	public FancyToy() {
		super(1);
	}

	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("thinkingInJava.ch14.FancyToy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		print(c);
		for (Class<?> cc : c.getInterfaces()) {
			print(cc);
		}
		Class<?> su = c.getSuperclass();
		Class<?> o = su.getSuperclass();
		try {
			Object obj = su.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		print(o);
	}

	public static void print(Class<?> c) {
		System.out.print("Class name:" + c.getName() + ",is interface?["
				+ c.isInterface() + "]," + "simple name:" + c.getSimpleName()
				+ ",Canonical name:" + c.getCanonicalName());
		System.out.println();
	}
}

class Toy {

	Toy(int i) {
	}
}

interface I1 {
}

interface I2 {
}

interface I3 {
}
