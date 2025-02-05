package DP;

/**
 * @author Hyper
 * @date 2023/10/05
 * @file M309_买卖股票的最佳时机含冷冻期.java
 * <p>
 * dp状态机
 * 分类讨论：
 * 1. 手上持有股票的最大收益
 * 2. 手上不持有股票且处于冷冻期的最大收益
 * 3. 手上不持有股票且不在冷冻期的最大收益
 */
public class M309_买卖股票的最佳时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][2], f[i - 1][1]);
        }

        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}
