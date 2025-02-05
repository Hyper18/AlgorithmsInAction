package DP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/05/12
 */
public class Q188_买卖股票的最佳时机IV_2 {
    private static final int INF = 0x3f3f3f3f;

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] f = new int[n][k + 1];
        int[][] g = new int[n][k + 1];

        f[0][0] = -prices[0];
        g[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            f[0][i] = g[0][i] = -INF / 2;
        }

        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], g[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                f[i][j] = Math.max(f[i - 1][j], g[i - 1][j] - prices[i]);
                g[i][j] = Math.max(g[i - 1][j], f[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(g[n - 1]).max().getAsInt();
    }
}
