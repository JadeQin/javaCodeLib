package googCodeJam.qualificationRound2010.fairWarning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class FairWarning {

	public void inputFile(String fileName) {
		String name = this.getClass().getResource(".").getPath() + fileName;
		BigInteger[][] num = readASCIIFileByLine(name);
		for(int i=0;i<num.length;i++){
			BigInteger[] b=num[i];
			Arrays.sort(b);
			String result=gcd(b);
			System.out.println("Case #"+(i+1)+": "+result);
		}
	}
	
	public static void main(String[] a){
		new FairWarning().inputFile("B-large-practice.in");
	}


	private static BigInteger[][] readASCIIFileByLine(String fileName) {
		BigInteger[][] num = null;
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new File(
					fileName)));
			String line = bf.readLine();
			int size = Integer.parseInt(line);
			num = new BigInteger[size][];
			int i = 0;
			while ((line = bf.readLine()) != null) {
				String[] str = line.split(" ");
				int n = Integer.valueOf(str[0]);
				num[i] = new BigInteger[n];
				for (int j = 0; j < n; j++) {
					num[i][j] = new BigInteger(str[j + 1]);
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	private String gcd(BigInteger[] b){
		BigInteger sub=b[1].subtract(b[0]);
		for(int j=2;j<b.length;j++){
			BigInteger temp=b[j].subtract(b[j-1]);
			sub=sub.gcd(temp);
		}
		BigInteger bi=b[0].mod(sub);
		if(bi.intValue()==0){
			return 0+"";
		}
		return sub.subtract(bi).toString();
	}
}
