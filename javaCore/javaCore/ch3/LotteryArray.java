package javaCore.ch3;

public class LotteryArray {

	public static void main(String[] args) {

		int NMAX = 1000000;

		// long a1 = System.currentTimeMillis();
		// new LotteryArray().f1(NMAX);
		// long a2 = System.currentTimeMillis();
		// System.out.println((a2 - a1));

		// long b1=System.currentTimeMillis();
		// new LotteryArray().f2(NMAX);
		// long b2=System.currentTimeMillis();
		// System.out.println((b2-b1));

		long c1 = System.currentTimeMillis();
		new LotteryArray().f4(NMAX);
		long c2 = System.currentTimeMillis();
		System.out.println((c2 - c1));
	}

	public void f1(int NMAX) {

		int[][] odds = new int[NMAX + 1][];
		for (int n = 0; n <= NMAX; n++)
			odds[n] = new int[n + 1];

		for (int n = 0; n < odds.length; n++) {
			for (int k = 0; k < odds[n].length; k++) {
				/*
				 * compute binomial coefficient
				 * n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
				 */
				int lotteryOdds = 1;
				for (int i = 1; i <= k; i++) {
					lotteryOdds = lotteryOdds * (n - i + 1) / i;
				}
				odds[n][k] = lotteryOdds;
			}
		}

		// printArrays(odds);
	}

	private void f2(int NMAX) {
		int[][] odds = new int[NMAX + 1][];

		for (int n = 0; n <= NMAX; n++) {
			odds[n] = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				odds[n][i] = 1;
			}
		}

		for (int i = 0; i < odds.length; i++) {
			for (int j = 1; j < odds[i].length - 1; j++) {
				odds[i][j] = odds[i - 1][j - 1] + odds[i - 1][j];
			}
		}
		// printArrays(odds);
	}

	private void f4(int NMAX) {
		int[][] odds = new int[NMAX][];

		for (int i = 0; i < NMAX; i++) {
			odds[i] = new int[i + 1];
			odds[i][0] = 1;
			odds[i][i] = 1;
			for (int j = 1; j < i; j++) {
				odds[i][j] = odds[i - 1][j - 1] + odds[i - 1][j];
			}
			if (i > 1) {
				odds[i - 2] = null;
			}
			if (i % 1000 == 0) {
				System.gc();
				System.out.println(i);
			}
			// printArrays(odds[i]);
		}
	}

	public void printArrays(int[][] arrays) {
		for (int[] row : arrays) {
			for (int odd : row) {
				System.out.printf("%4d", odd);
			}
			System.out.println();
		}
	}

	public void printArrays(int[] arrays) {
		for (int odd : arrays) {
			System.out.printf("%4d", odd);
		}
		System.out.println();
	}
}
