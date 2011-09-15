package thinkingInJava.ch14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class ShowMethods<T> {

	public void showMethods(T t) {
		Class<?> c = t.getClass();
		Method[] methods = c.getDeclaredMethods();
		Constructor<?>[] constructors = c.getDeclaredConstructors();
		for (Constructor cc : constructors) {
			System.out.println(cc);
		}
		for (Method m : methods) {
			System.out.println(m);
		}
	}

	public static void main(String[] args) {
		new ShowMethods<ShowMethods>().showMethods(new ShowMethods());
	}
}
