package Math;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/04/30，2024/10/20
 * <p>
 * 思路
 * 模拟
 */
public class M908_最小差值I {
    public int smallestRangeI(int[] nums, int k) {
        int ans = Arrays.stream(nums).max().getAsInt() - Arrays.stream(nums).min().getAsInt() - 2 * k;

        return ans > 0 ? ans : 0;
    }

    public int smallestRangeI2(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt(), mn = Arrays.stream(nums).min().getAsInt();

        return (mx - mn) / 2 < k ? 0 : mx - mn - 2 * k;
    }
}
