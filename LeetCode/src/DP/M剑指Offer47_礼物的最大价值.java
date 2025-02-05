package DP;

/**
 * @author Hyper
 * @date 2023/03/08
 * @file M剑指Offer47_礼物的最大价值.java
 * <p>
 * 思路
 * 朴素二维DP
 * 1. 状态表示
 * 集合：f[i][j]表示到达第i行第j列时所能获取的最大价值
 * 属性：Max
 * 2. 状态计算
 * f[i][j] = max(f[i - 1][j], f[i][j - 1]) + grid[i][j]
 * 当前状态f[i][j]只能从左侧f[i - 1][j]或上方f[i][j - 1]转移而来
 */
public class M剑指Offer47_礼物的最大价值 {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = i == 0 ? grid[i][0] : f[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }

        return f[m - 1][n - 1];
    }
}
