package Math;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/04/30
 */
public class M908_最小差值I {
    public int smallestRangeI(int[] nums, int k) {
        int ans = Arrays.stream(nums).max().getAsInt() - Arrays.stream(nums).min().getAsInt() - 2 * k;

        return ans > 0 ? ans : 0;
    }
}
