package DP;

/**
 * @author Hyper
 * @date 2022/03/08
 * <p>
 * 可将起始台阶为0/1开始的问题转化到最后统计结果时判断
 * 1. dp -- O(n)
 * 2. 状压dp -- O(n)
 */
public class Q746_使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }

        return dp[n - 1] <= dp[n - 2] ? dp[n - 1] : dp[n - 2];
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int pre = cost[0];
        int curr = cost[1];
        for (int i = 2; i < n; i++) {
            int tmp = pre < curr ? pre + cost[i] : curr + cost[i];
            pre = curr;
            curr = tmp;
        }

        return pre <= curr ? pre : curr;
    }
}
