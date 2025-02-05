package DP;

/**
 * @author Hyper
 * @date 2023/08/10
 * @file M1289_下降路径最小和II.java
 * <p>
 * 思路
 * DP
 */
public class M1289_下降路径最小和II {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] f = grid;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j) {
                        continue;
                    }
                    min = Math.min(min, f[i - 1][k]);
                }
                f[i][j] += min;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, f[n - 1][i]);
        }

        return ans;
    }
}
