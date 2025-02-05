package DP.Knapsack;

/**
 * @author Hyper
 * @date 2025/01/18
 * @file M3287_求出数组中最大序列值.java
 * <p>
 * 思路@纯金是单质
 * 位运算+01背包
 * 核心在于根据子序列的边界划分前后缀
 * 和常规的DP不同，不是从状态转移的来源更新当前状态，
 * 而是由当前状态更新其他状态
 */
public class M3287_求出数组中最大序列值 {
    private final int N = 1 << 7;

    public int maxValue(int[] nums, int k) {
        int n = nums.length;
        boolean[][][] f = new boolean[n + 1][k + 1][N + 1], g = new boolean[n + 1][k + 1][N + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= Math.min(k, i + 1); j++) {
                System.arraycopy(f[i][j], 0, f[i + 1][j], 0, N + 1);
                if (j == 1) {
                    f[i + 1][j][nums[i]] = true;
                }
                for (int x = 0; x <= N; x++) {
                    if (f[i][j - 1][x]) {
                        f[i + 1][j][x | nums[i]] = true;
                    }
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= Math.min(k, n - i); j++) {
                System.arraycopy(g[i + 1][j], 0, g[i][j], 0, N + 1);
                if (j == 1) {
                    g[i][j][nums[i]] = true;
                }
                for (int x = 0; x <= N; x++) {
                    if (g[i + 1][j - 1][x]) {
                        g[i][j][x | nums[i]] = true;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = k - 1; i + k < n; i++) {
            for (int j = 0; j <= N; j++) {
                if (!g[i + 1][k][j]) {
                    continue;
                }
                for (int x = 0; x <= N; x++) {
                    if (f[i + 1][k][x]) {
                        ans = Math.max(ans, x ^ j);
                    }
                }
            }
        }

        return ans;
    }
}
