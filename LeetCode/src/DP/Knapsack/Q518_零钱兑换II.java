package DP.Knapsack;

/**
 * @author Hyperspace
 * @date 2022/03/19，2024/03/25
 * 完全背包求方案数
 * <p>
 * 1. 状态表示
 * 集合：f[i]表示能凑出总金额为i的方案数
 * 属性：cnt
 * 2. 状态计算
 * f[j] += f[j - coins[i]]
 */
public class Q518_零钱兑换II {
    final int N = 5010;
    int[] f = new int[N];

    public int change(int amount, int[] coins) {
        int n = coins.length;
        f[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                f[j] += f[j - coins[i]];
            }
        }

        return f[amount];
    }

    public int change2(int amount, int[] coins) {
        f[0] = 1;
        for (int v : coins) {
            for (int j = v; j <= amount; j++) {
                f[j] += f[j - v];
            }
        }

        return f[amount];
    }
}
