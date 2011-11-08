package euler.p14;

public class P14 {

    public static int getSequence(int num) {
        int count = 0;
        long tmpNum = num;
        while (tmpNum != 1) {
            if (tmpNum % 2 == 0) {
                tmpNum /= 2;
            } else {
                tmpNum = tmpNum * 3 + 1;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int count = 0;
        int num = 0;
        long start = System.currentTimeMillis();
        for (int i = 2; i < 1000000; i++) {
            int c = getSequence(i);
            if (count < c) {
                count = c;
                num = i;
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(num);
        System.out.println(count);
        
    }
}
