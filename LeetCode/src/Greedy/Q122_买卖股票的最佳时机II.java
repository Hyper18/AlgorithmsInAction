package Greedy;

/**
 * @author Hyperspace
 * @date 2022/03/27
 * <p>
 * 思路
 * 1. 贪心 -- O(n)
 * 一开始容易考虑怎样在某一天卖出再买入能最大化利润 -- dp
 * 但根据实际情况而言
 * 还可以只需要从买入后的第二天开始比较
 * 只要后一天的股市好于前一天，则卖出
 * 并顺次累加利润即可 -- 贪心
 * <p>
 * 官解：贪心的角度考虑，我们每次选择贡献大于 0 的区间即能使得答案最大化
 * <p>
 * 2. dp
 * 状态转移方程的含义：
 * dp[i][0] = 在第i天进行交易后不持有一股情况下的最大利润
 * dp[i][1] = 在第i天进行交易后持有着一股情况下的最大利润
 * <p>
 * 3. 状压dp
 */
public class Q122_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }

    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int pre = 0;
        int cur = -prices[0];
        for (int i = 1; i < n; i++) {
            int tmp = pre;
            pre = Math.max(pre, cur + prices[i]);
            cur = Math.max(cur, tmp - prices[i]);
        }

        return pre;
    }
}