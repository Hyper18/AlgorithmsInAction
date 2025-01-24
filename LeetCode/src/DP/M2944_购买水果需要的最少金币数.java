package DP;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/01/24
 * @file M2944_购买水果需要的最少金币数.java
 */
public class M2944_购买水果需要的最少金币数 {
    private final int N = 1010, INF = 0x3f3f3f3f;
    private int[] f = new int[N];

    public int minimumCoins(int[] prices) {
        int n = prices.length;
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= Math.min(i << 1, n); j++) {
                f[j] = Math.min(f[j], f[i - 1] + prices[i - 1]);
            }
        }

        return f[n];
    }
}
