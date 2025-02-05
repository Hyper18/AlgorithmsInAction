package DP;

/**
 * @author Hyper
 * @date 2022/02/13，2023/10/01
 * <p>
 * 思路
 * 1. 单变量记录历史低点，遍历找从买入后可获得的最大利润 -- O(n)
 * 2. DP
 * 两个约束条件：
 * 条件 1：你不能在买入股票前卖出股票；
 * 条件 2：最多只允许完成一笔交易。
 * 3. 补一个枚举。。java暴力法总超时
 */
public class Q121_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - min);
            min = Math.min(price, min);
        }

        return maxProfit;
    }

    public int maxProfit2_1(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    public int maxProfit2_2(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return 0;
        }

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }

    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }

    public int maxProfit4(int[] prices) {
        int n = prices.length;
        int s1 = -prices[0], s2 = 0;
        for (int i = 1; i < n; i++) {
            s2 = Math.max(s2, s1 + prices[i]);
            s1 = Math.max(s1, -prices[i]);
        }

        return s2;
    }
}
