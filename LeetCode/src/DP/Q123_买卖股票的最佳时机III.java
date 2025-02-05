package DP;

/**
 * @author Hyper
 * @date 2023/10/03
 * @file Q123_买卖股票的最佳时机III.java
 * <p>
 * 思路
 * dp状态机
 * 分类讨论可能的状态：
 * 1. 未进行任何交易 s0 = 0
 * 2. 仅进行一次买操作 s1 = max(s1, -prices[i])
 * 3. 完成一笔买卖交易 s2 = max(s2, s1 + prices[i])
 * 4. 已完成一笔交易，再次进行第二次买操作 s3 = max(s3, s2 - prices[i])
 * 5. 完成两笔买卖交易 s4 = max(s4, s3 + prices[i])
 */
public class Q123_买卖股票的最佳时机III {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int s1 = -prices[0], s2 = 0, s3 = -prices[0], s4 = 0;
        for (int i = 1; i < n; i++) {
            s1 = Math.max(s1, -prices[i]);
            s2 = Math.max(s2, s1 + prices[i]);
            s3 = Math.max(s3, s2 - prices[i]);
            s4 = Math.max(s4, s3 + prices[i]);
        }

        return s4;
    }
}
