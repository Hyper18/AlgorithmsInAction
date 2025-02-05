package DP;

/**
 * @author Hyper
 * @date 2023/10/02
 * @file Q122_买卖股票的最佳时机II.java
 * <p>
 * 思路
 * dp
 */
public class Q122_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int s1 = 0, s2 = -prices[0];
        for (int i = 1; i < n; i++) {
            int t = s1;
            s1 = Math.max(s1, s2 + prices[i]);
            s2 = Math.max(s2, t - prices[i]);
        }

        return s1;
    }
}
