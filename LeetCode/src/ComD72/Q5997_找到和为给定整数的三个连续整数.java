package ComD72;

import java.util.ArrayList;

/**
 * @author Hyperspace
 * @date 2022/02/19
 */
public class Q5997_找到和为给定整数的三个连续整数 {
    public long[] sumOfThree(long num) {
        long[] res = new long[3];
        if (num % 3 != 0) {
            return new long[]{};
        }
        long mid = num / 3;
        for (int i = 0; i < res.length; i++) {
            res[i] = mid - 1 + i;
        }
        return res;
    }
}
