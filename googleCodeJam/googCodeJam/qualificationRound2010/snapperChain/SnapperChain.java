package googCodeJam.qualificationRound2010.snapperChain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SnapperChain {

	public void inputFile(String fileName) {
		String name = this.getClass().getResource(".").getPath() + fileName;
		int[][] num = readASCIIFileByLine(name);
		int i = 1;
		for (int[] n : num) {
			String result = "Case #" + i + ": " + process2(n[0], n[1]);
			System.out.println(result);
			i++;
		}
	}

	private String process1(int switchCount, int handleCount) {
		double d = Math.pow(2, switchCount) - handleCount;
		if (d > 1) {
			return "OFF";
		}
		String s = Integer.toBinaryString(handleCount);
		String str = s.substring(s.length() - switchCount);
		boolean result = str.matches("(1)+");
		if (result)
			return "ON";
		else
			return "OFF";
	}

	private String process2(int switchCount, int handleCount) {
		int x = (1 << switchCount);
		while (handleCount >= x) {
			handleCount %= x;
		}
		if (handleCount == x - 1)
			return "ON";
		return "OFF";
	}

	private static int[][] readASCIIFileByLine(String fileName) {
		int[][] num = null;
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new File(
					fileName)));
			String line = bf.readLine();
			int size = Integer.parseInt(line);
			num = new int[size][];
			int i = 0;
			while ((line = bf.readLine()) != null) {
				String[] str = line.split(" ");
				num[i] = new int[2];
				num[i][0] = Integer.parseInt(str[0]);
				num[i][1] = Integer.parseInt(str[1]);
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}
}
