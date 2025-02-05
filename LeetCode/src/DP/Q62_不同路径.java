package DP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/03/08，2024/09/23
 * @file Q62_不同路径.java
 * <p>
 * 思路
 * DP
 * 1. 状态表示
 * 集合：f[i][j]为从(0, 0)到达(i, j)的所有可行路径数目
 * 属性：cnt
 * 2. 状态计算
 * f[i][j] = f[i - 1][j] + f[i][j - 1]
 */
public class Q62_不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        Arrays.fill(f[0], 1);
        for (int i = 1; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[j] += f[j - 1];
            }
        }

        return f[n - 1];
    }
}
