package DP;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/03/19
 * <p>
 * 这题主要难点在于dp的过程是求最小
 * 因此在考虑状态转移方程时，应当先初始化一个最大值
 * dp[i]应从dp[i - coins[j]]转移过来
 */
public class Q322_零钱兑换 {
    private static final int MAX = 10000 + 10;
    private static final int INF = 0x3f3f3f3f;
    private int[] dp = new int[MAX];

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] > i) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }

        return dp[amount] <= amount ? dp[amount] : -1;
    }
}
