package Competition.ComD72;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2022/02/19
 */
public class Q5998_拆分成最多数目的偶整数之和 {
    public static void main(String[] args) {
        System.out.println(maximumEvenSplit(12));
    }

    public static List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) {
            return new ArrayList<>();
        }
        List<Long> res = new ArrayList<>();
        long half = finalSum / 2;
        int[] dp = new int[Math.toIntExact(half) + 1];
        for (int i = 2; i < half; i++) {

        }
        for (int i : dp) {
            res.add((long) i * 2);
        }

        return res;
    }
}
