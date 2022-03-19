package DP.Knapsack;

/**
 * @author Hyperspace
 * @date 2022/03/19
 * 完全背包
 */
public class Q518_零钱兑换II {
    private static final int MAX = 5000 + 10;
    private int[] dp = new int[MAX];

    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
