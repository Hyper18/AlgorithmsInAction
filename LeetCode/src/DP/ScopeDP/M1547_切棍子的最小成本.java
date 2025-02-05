package DP.ScopeDP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/11/11
 * @file M1547_切棍子的最小成本.java
 * <p>
 * 思路
 * 区间DP
 * 排序原数组，使得切割后得到的是连续的区间
 * 对位于k下标的切割，其总贡献为 左侧贡献 + 本次切割的木棍长度 + 右侧贡献
 * f[i][k - 1] + (a[j + 1] - a[i - 1]) + f[k + 1][j]
 */
public class M1547_切棍子的最小成本 {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int len = m + 2;
        int[] a = new int[len];
        int[][] f = new int[len][len];
        a[0] = 0;
        System.arraycopy(cuts, 0, a, 1, m);
        a[len - 1] = n;
        for (int i = m; i >= 1; i--) {
            for (int j = i; j <= m; j++) {
                f[i][j] = i == j ? 0 : Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k - 1] + f[k + 1][j]);
                }
                f[i][j] += a[j + 1] - a[i - 1];
            }
        }

        return f[1][m];
    }
}
