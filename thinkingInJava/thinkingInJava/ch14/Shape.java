package thinkingInJava.ch14;

public class Shape {

	public void draw() {
		System.out.println(this + ".draw()");
	}

	public void rotate() {
		if (this instanceof Circle) {
			draw();
		}
	}

	public static void main(String[] args) {
		Rhomboid rh = new Rhomboid();
		Shape sh = (Shape) rh;
		Shape ss = rh;
		// FancyToy.print(Rhomboid.class);
		Integer i = new Integer(1);
		System.out.println(i.getClass() == Integer.TYPE);// false
		System.out.println(i.getClass() == int.class);// false
		System.out.println(int.class == Integer.TYPE);// true
		System.out.println(i.getClass().equals(Integer.TYPE));// false
		System.out.println(i.getClass().equals(int.class));// false
		System.out.println(int.class.equals(Integer.TYPE));// true
		/*
		 * false false true false false true
		 */

		// FancyToy.print(sh.getClass());
		// FancyToy.print(ss.getClass());

		Rhomboid r = (Rhomboid) sh;
		// FancyToy.print(r.getClass());
		rh.rotate();
		sh.rotate();
		ss.rotate();
		r.rotate();

	}
}

class Circle extends Shape {

	public String toString() {
		return "Circle";
	}
}

class Square extends Shape {

	public String toString() {
		return "Square";
	}
}

class Triangle extends Shape {

	public String toString() {
		return "Triangle";
	}
}

class Rhomboid extends Shape {

	public String toString() {
		return "Rhomboid";
	}
}