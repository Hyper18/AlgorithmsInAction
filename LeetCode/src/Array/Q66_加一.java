package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/02/17
 * <p>
 * 思路
 * 模拟
 */
public class Q66_加一 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (Arrays.stream(digits).filter(e -> e == 9).count() == len) {
            int[] res = new int[len + 1];
            res[0] = 1;
            return res;
        }
        for (int i = len - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        return digits;
    }
}
