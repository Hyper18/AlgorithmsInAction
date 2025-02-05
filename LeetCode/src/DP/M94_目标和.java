package DP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/06/30
 * @file M94_目标和.java
 * <p>
 * 思路
 * DP
 */
public class M94_目标和 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int diff = sum - target;
        if (diff % 2 != 0 || diff < 0) {
            return 0;
        }
        target = diff / 2;
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                f[j] += f[j - nums[i]];
            }
        }

        return f[target];
    }
}
