package euler.p17;

import org.junit.Test;

public class P17 {

    static int HUNDRED_LENGTH = "hundred".length();

    static int THOUSAND_LENGTH = "thousand".length();

    static int AND_LENGTH = "and".length();

    static String[] units = new String[] { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten" };

    static String[] teens = new String[] { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen" };

    static String[] tys = new String[] { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 1001; i++) {
            count += checkLength(i);
        }
        System.out.println(count);
    }

    public static int checkLength(int num) {
        int count = 0;

        if (num / 1000 > 0) {
            count += units[num / 100].length() + THOUSAND_LENGTH;
        }
        
        if (num / 1000 > 0 && num % 1000 > 0) {
            count += AND_LENGTH;
        }
        num %= 1000;

        if (num / 100 > 0) {
            count += units[num / 100].length() + HUNDRED_LENGTH;
        }

        if (num / 100 > 0 && num % 100 > 0) {
            count += AND_LENGTH;
        }
        num %= 100;

        switch (num / 10) {
        case 0: {
            count += units[num].length();
            break;
        }
        case 1: {
            count += teens[num % 10].length();
            break;
        }
        default: {
            count += tys[num / 10 - 2].length() + units[num % 10].length();
            break;
        }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(checkLength(81));
        System.out.println(checkLength(11));
        System.out.println(checkLength(20));
        System.out.println(checkLength(21));
        System.out.println(checkLength(342));
        System.out.println(checkLength(115));
    }
}
