package Y2015A;

import java.util.Calendar;

/**
 * @author Hyperspace
 * @date 2022/03/21
 */
public class Q2星系炸弹 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 11 - 1, 9);
        calendar.add(Calendar.DATE, 1000);
        // int y = calendar.get(Calendar.YEAR);
        // int m = calendar.get(Calendar.MONTH) + 1;
        // int d = calendar.get(Calendar.DATE);
        // System.out.printf("%d-%d-%d\n", y, m, d);
        System.out.println(calendar.getTime());
    }
}
