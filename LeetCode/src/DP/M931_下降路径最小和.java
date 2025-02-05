package DP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/07/13
 * @file M931_下降路径最小和.java
 * <p>
 * 思路
 * 线性DP
 */
public class M931_下降路径最小和 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] f = new int[n][n];
        f[0] = Arrays.copyOf(matrix[0], n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int t = f[i - 1][j];
                if (j > 0) {
                    t = Math.min(t, f[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    t = Math.min(t, f[i - 1][j + 1]);
                }
                f[i][j] = t + matrix[i][j];
            }
        }

        return Arrays.stream(f[n - 1]).min().getAsInt();
    }
}
