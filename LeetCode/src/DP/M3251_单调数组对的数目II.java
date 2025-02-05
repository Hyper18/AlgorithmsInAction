package DP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/11/28
 * @file M3251_单调数组对的数目II.java
 * <p>
 * 思路@灵茶山艾府
 * 前缀和+DP
 */
public class M3251_单调数组对的数目II {
    final int MOD = (int) 1e9 + 7;

    public int countOfPairs(int[] nums) {
        int n = nums.length, m = Arrays.stream(nums).max().getAsInt();
        long[][] f = new long[n][m + 1];
        long[] pre = new long[m + 1];
        Arrays.fill(f[0], 0, nums[0] + 1, 1);
        for (int i = 1; i < n; i++) {
            pre[0] = f[i - 1][0];
            for (int k = 1; k <= m; k++) {
                pre[k] = (pre[k - 1] + f[i - 1][k]) % MOD;
            }
            for (int j = 0; j <= nums[i]; j++) {
                int maxK = j + Math.min(nums[i - 1] - nums[i], 0);
                f[i][j] = maxK >= 0 ? pre[maxK] % MOD : 0;
            }
        }

        return (int) (Arrays.stream(f[n - 1], 0, nums[n - 1] + 1).sum() % MOD);
    }
}
