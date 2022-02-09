import java.util.Scanner;

/**
 * @author Vincent
 */
public class P1422_小玉家的电费 {
    private static final int INDICATOR_1 = 150;
    private static final int INDICATOR_2 = 400;
    private static final double PRICE_SPAN1 = 0.4463;
    private static final double PRICE_SPAN2 = 0.4663;
    private static final double PRICE_SPAN3 = 0.5663;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int kilowatt_hour = sc.nextInt();
        double sum;
        if (kilowatt_hour <= INDICATOR_1) {
            sum = PRICE_SPAN1 * kilowatt_hour;
        } else if (kilowatt_hour <= INDICATOR_2) {
            sum = PRICE_SPAN1 * INDICATOR_1;
            sum += PRICE_SPAN2 * (kilowatt_hour - INDICATOR_1);
        } else {
            sum = PRICE_SPAN1 * INDICATOR_1;
            sum += PRICE_SPAN2 * (INDICATOR_2 - INDICATOR_1);
            sum += PRICE_SPAN3 * (kilowatt_hour - INDICATOR_2);
        }

        System.out.println(String.format("%.1f", sum));
    }
}
