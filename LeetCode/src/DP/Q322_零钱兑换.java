package DP;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/03/19，2024/03/24
 * <p>
 * 这题主要难点在于dp的过程是求最小
 * 因此在考虑状态转移方程时，应当先初始化一个最大值
 * f[i]应从f[i - coins[j]]转移过来
 * <p>
 * 1. 状态表示
 * 集合：f[i]表示凑出总金额为i所需的最小硬币数目
 * 属性：min
 * 2. 状态计算
 * f[i] = min(f[i], f[i - coin[j]] + 1)
 */
public class Q322_零钱兑换 {
    final int N = (int) (1e4 + 7), INF = 0x3f3f3f3f;
    int[] f = new int[N];

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] > i) {
                    continue;
                }
                f[i] = Math.min(f[i], f[i - coins[j]] + 1);
            }
        }

        return f[amount] <= amount ? f[amount] : -1;
    }

    public int coinChange2(int[] coins, int amount) {
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    f[i] = Math.min(f[i], f[i - coin] + 1);
                }
            }
        }

        return f[amount] <= amount ? f[amount] : -1;
    }
}
