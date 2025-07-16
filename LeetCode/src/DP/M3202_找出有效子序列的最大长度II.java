package DP;

/**
 * @author Hyperspace
 * @date 2025/07/17
 * @file M3202_找出有效子序列的最大长度II.java
 * <p>
 * 思路
 * dp
 */
public class M3202_找出有效子序列的最大长度II {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] f = new int[k][k];
        for (int i = 0; i < n; i++) {
            for (int x = nums[i] % k, y = 0; y < k; y++) {
                f[y][x] = f[x][y] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                ans = Math.max(ans, f[i][j]);
            }
        }

        return ans;
    }
}
