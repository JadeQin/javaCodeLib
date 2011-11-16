package euler.p19;

/**
 * 
 */
public class P19 {
    
    public static void main(String[] args) {
        int countDays = 0;
        for (int i = 1901; i < 2001; i++) {
            if (i % 100 == 0) {
                if (i % 400 == 0) {
                    countDays += 366;
                } else {
                    countDays += 365;
                }
            } else if (i % 4 == 0) {
                countDays += 366;
            } else {
                countDays += 365;
            }
        }
        
        System.out.println(countDays);
        System.out.println(countDays%7);
        System.out.println(countDays/7);
    }
}
