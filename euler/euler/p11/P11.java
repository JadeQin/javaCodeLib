package euler.p11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class P11 {

	public static void main(String[] args) throws Exception {
		System.out.println(new P11().doIt());
	}

	public long doIt() throws Exception {
		long result = 0;
		int[][] num = getDataFile();
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				long n1 = 0;
				long n2 = 0;
				long n3 = 0;
				long n4 = 0;
				if (j < 17) {
					n1 = num[i][j] * num[i][j + 1] * num[i][j + 2]
							* num[i][j + 3];
				}
				if (i < 17) {
					n2 = num[i][j] * num[i + 1][j] * num[i + 2][j]
							* num[i + 3][j];
				}
				if (i < 17 && j < 17) {
					n3 = num[i][j] * num[i + 1][j + 1] * num[i + 2][j + 2]
							* num[i + 3][j + 3];
				}
				if (i < 17 && j > 2) {
					n4 = num[i][j] * num[i + 1][j - 1] * num[i + 2][j - 2]
							* num[i + 3][j - 3];
				}
				long m=n1>n2?n1:n2;
				long l=n3>n4?n3:n4;
				long n=m>l?m:l;
				result = result > n ? result : n;
			}
		}
		return result;
	}

	public int[][] getDataFile() throws Exception {
		int[][] num = new int[20][20];
		File file = new File(this.getClass().getResource(".").getPath()
				+ "P11.txt");
		FileReader fr = new FileReader(file);
		BufferedReader bf = new BufferedReader(fr);
		String line = bf.readLine();
		for (int i = 0; i < 20; i++) {
			String[] s = line.split(" ");
			for (int j = 0; j < s.length; j++) {
				num[i][j] = Integer.valueOf(s[j]);
			}
			line = bf.readLine();
		}
		return num;
	}
}

//51267216
//70600674
