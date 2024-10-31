package DP;

/**
 * @author Hyperspace
 * @date 2024/10/31
 * @file M3165_不包含相邻元素的子序列的最大和.java
 * <p>
 * 思路
 * DP 卡case518，TLE
 * 考虑每次修改的时间复杂度
 * 应使用线段树处理单点修改
 */
public class M3165_不包含相邻元素的子序列的最大和 {
    private final int MOD = (int) 1e9 + 7;

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int ans = 0;
        for (int[] q : queries) {
            nums[q[0]] = q[1];
            ans = (ans + getSum(nums)) % MOD;
        }

        return ans;
    }

    private int getSum(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = Math.max(nums[0], 0);
        if (n < 2) {
            return f[0];
        }
        f[1] = Math.max(nums[1], f[0]);
        for (int i = 2; i < n; i++) {
            f[i] = nums[i] <= 0 ? f[i - 1] : Math.max(f[i - 1], f[i - 2] + nums[i]);
        }

        return f[n - 1];
    }
}
