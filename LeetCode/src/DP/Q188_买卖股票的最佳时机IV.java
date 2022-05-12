package DP;

/**
 * @author Hyperspace
 * @date 2022/05/12
 */
public class Q188_买卖股票的最佳时机IV {
    private static final int N = 1000 + 10, M = 100 + 5, INF = 0x3f3f3f3f;
    private static int[][][] f = new int[N][M][2];

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                f[i][j][0] = j == 0 ? 0 : -INF;
                f[i][j][1] = -INF;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1] + prices[i - 1]);
                f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - prices[i - 1]);
            }
        }

        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = Math.max(ans, f[n][i][0]);
        }

        return ans;
    }
}
