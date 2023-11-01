package DP;

/**
 * @author Hyperspace
 * @date 2023/10/06
 * @file M714_买卖股票的最佳时机含手续费.java
 * <p>
 * 思路
 * 参Q122
 */
public class M714_买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int s1 = 0, s2 = -prices[0];
        for (int i = 1; i < n; i++) {
            int t = s1;
            s1 = Math.max(s1, s2 + prices[i] - fee);
            s2 = Math.max(s2, t - prices[i]);
        }

        return s1;
    }
}
