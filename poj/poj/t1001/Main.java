package poj.t1001;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		double a = cin.nextDouble(), b = cin.nextInt();
		double sum = 1;
		for (int i = 0; i < b; i++) {
			sum *= a;
		}
		System.out.print(sum);
	}
}
