package jsop.test;

import java.math.BigInteger;

public class ShuiXianShu {

	public static void main(String[] args) {
		System.out.println(new ShuiXianShu().getMaxNum(3));
	}

	private BigInteger getMaxNum(int length) {
		StringBuffer sb = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			sb.append("9");
		}
		BigInteger max = new BigInteger(sb.toString()).divide(new BigInteger(
				length + ""));
		BigInteger num = new BigInteger("9").pow(length);

		return max.min(num);
	}
}
