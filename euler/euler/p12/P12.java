package euler.p12;

public class P12 {

	public static void main(String... strings) {
		long num = 0;
		long start = System.currentTimeMillis();
		for (int i = 1;; i++) {
			int count = 0;
			num += i;
			for (int j = 1; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					count++;
				}
			}
			if (count >= 250) {
				long end = System.currentTimeMillis();
				System.out.println(end - start);
				System.out.println(num);
				System.out.println(count);
				break;
			}
		}
	}
}
