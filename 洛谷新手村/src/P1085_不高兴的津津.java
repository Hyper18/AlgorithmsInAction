import java.util.Scanner;

/**
 * @author Vincent
 */
public class P1085_不高兴的津津 {
    private static final int UNHAPPY_THRESHOLD = 8;
    private static final int STUDY_DAYS = 7;
    private static final int STUDY_CATEGORIES = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] hours = new int[STUDY_DAYS][STUDY_CATEGORIES];
        int indicator = 0;
        int cnt = 0;
        for (int i = 0; i < STUDY_DAYS; i++) {
            String s = sc.nextLine();
            hours[i][0] = Integer.parseInt(s.split(" ")[0]);
            hours[i][1] = Integer.parseInt(s.split(" ")[1]);
            int sum = hours[i][0] + hours[i][1];

            if (cnt < sum) {
                cnt = sum;
                indicator = i;
            }
        }

        if (cnt < UNHAPPY_THRESHOLD) {
            System.out.println(0);
        } else {
            System.out.println(indicator + 1);
        }
    }
}
