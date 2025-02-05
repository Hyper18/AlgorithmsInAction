package DP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/11/20
 * @file M799_香槟塔.java
 * <p>
 * 思路，当前层的状态由上一层转移得到
 * DP
 * n = 1 s = 1
 * n = 2 s = 2
 * n = 3 s = 3
 * n = 4 s = 4
 * s(n) = s(n - 1) + 1 = currentRow
 * <p>
 * 1. 状态表示
 * 集合：f[i][j]表示第i行第j个位置上的杯子的水体积
 * 2. 状态计算
 * f[i + 1][j] = f[i + 1][j + 1] += (f[i][j] - 1) / 2D
 * <p>
 * 优化：使用滚动数组，这样操作的空间复杂度为O(n)
 */
public class M799_香槟塔 {
    final int N = 105;
    double[][] f = new double[N][N];

    public double champagneTower(int poured, int query_row, int query_glass) {
        f[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (f[i][j] >= 1) {
                    f[i + 1][j] += (f[i][j] - 1) / 2D;
                    f[i + 1][j + 1] += (f[i][j] - 1) / 2D;
                }
            }
        }

        return Math.min(1, f[query_row][query_glass]);
    }

    double[] g = new double[N];

    public double champagneTower2(int poured, int query_row, int query_glass) {
        g[0] = poured;
        for (int i = 0; i < N; i++) {
            if (query_row == i) {
                return Math.min(1, g[query_glass]);
            }
            double[] next = new double[N];
            for (int j = 0; j <= i; j++) {
                if (g[j] >= 1) {
                    double overflow = g[j] - 1;
                    next[j] += overflow / 2D;
                    next[j + 1] += overflow / 2D;
                }
            }
            g = Arrays.copyOf(next, N);
        }

        return 0;
    }
}
