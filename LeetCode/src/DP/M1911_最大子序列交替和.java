package DP;

/**
 * @author Hyperspace
 * @date 2023/07/11
 * @file M1911_最大子序列交替和.java
 * <p>
 * 思路
 * DP
 */
public class M1911_最大子序列交替和 {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long x = nums[0], y = 0;
        for (int i = 1; i < n; i++) {
            x = Math.max(x, y + nums[i]);
            y = Math.max(y, x - nums[i]);
        }

        return x;
    }
}
