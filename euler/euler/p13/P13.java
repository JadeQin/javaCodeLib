package euler.p13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;

public class P13 {

    private BigInteger[] getDataFile() throws Exception {
        BigInteger[] num = new BigInteger[100];
        BufferedReader bf = new BufferedReader(new FileReader(new File(this
                .getClass().getResource(".").getPath()
                + "p13.txt")));
        for(int i=0;i<100;i++) {
            String line=bf.readLine();
            num[i]=new BigInteger(line);
        }
        return num;
    }
    
    public static void main(String[] args) throws Exception{
        BigInteger[] bigs=new P13().getDataFile();
        BigInteger sum=new BigInteger("0");
        for(BigInteger i:bigs){
            sum=sum.add(i);
        }
        System.out.println(sum);
    }
}
