package agileJava.ch15;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class TestRunner {

	private Class clazz;

	public TestRunner(Class clazz) {
		this.clazz = clazz;
	}

	public TestRunner(String className) throws ClassNotFoundException {
		this(Class.forName(className));
	}

	public void run() {
		for (Method m : clazz.getDeclaredMethods()) {
			run(m);
		}
	}

	private void run(Method method) {
		Object obj;
		try {
			obj = clazz.newInstance();
			method.invoke(obj, new Object[] {});
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
