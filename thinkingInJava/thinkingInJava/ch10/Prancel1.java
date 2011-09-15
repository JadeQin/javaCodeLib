package thinkingInJava.ch10;

public class Prancel1 {

	class Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	class Destination {
		private String label;

		Destination(String label) {
			this.label = label;
		}

		String readLabel() {
			return label;
		}
	}

	public void ship(String str) {
		Contents c = new Contents();
		Destination d = new Destination(str);
		System.out.println(d.readLabel());
	}

	public static void main(String[] a) {
		Prancel1 p = new Prancel1();
		p.ship("");
	}
}
