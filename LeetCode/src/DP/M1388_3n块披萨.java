package DP;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2023/08/18
 * @file M1388_3n块披萨.java
 * <p>
 * 思路
 * DP，类比Q213
 */
public class M1388_3n块披萨 {
    int len;

    public int maxSizeSlices(int[] slices) {
        len = slices.length;
        return Math.max(getMax(Arrays.copyOf(slices, len - 1)), getMax(Arrays.copyOfRange(slices, 1, len)));
    }

    private int getMax(int[] s) {
        int m = s.length, n = len / 3;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Math.max(f[i - 1][j], (i >= 2 ? f[i - 2][j - 1] : 0) + s[i - 1]);
            }
        }

        return f[m][n];
    }
}
