package DP.Knapsack;

/**
 * @author Hyper
 * @date 2023/10/24
 * @file M1155_掷骰子等于目标和的方法数.java
 * <p>
 * 思路
 * DP，分组背包
 * 依次枚举物品组 -> 枚举容量 -> 枚举决策
 * 本题中物品为骰子，背包容量为正面朝上的数字之和，决策为当前投掷到的点数1~k
 * 观察到n、k均不大于30，时间复杂度O(n * m * t)，最大9*10^5
 * 1. 状态表示
 * 集合：f[i][j]表示投出骰子个数为i且当前正面朝上的数字之和为j时，所有可能的方案数
 * 属性：cnt
 * 2. 状态计算
 * 令l为第i次投掷时得到的点数，则i - 1次投出的值为j - l
 * 此时的累计方案数为：
 * f[i][j] = (f[i][j] + f[i - 1][j - l]) % MOD
 * <p>
 * 空间优化@宫水三叶
 * 滚动数组
 * f[i][j]明确只依赖于f[i − 1][x]，且x < j
 * <p>
 * 取消物品维度
 * 注1：f[j]不能从上一次的f[j]转移过来
 * 注2：关于f[j] = 0的情况，由于本题要求使用所有n个骰子，
 * 因此少于n个骰子但和为target的情况不计数
 * 因此仅第一次使用f[0] = 1后，后续遍历均清零
 * 注3：由于2/3的做法均只优化空间
 * 因此在空间足够情况下直接按1二维朴素的方式写即可
 */
public class M1155_掷骰子等于目标和的方法数 {
    final int MOD = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int l = 1; l <= k && l <= j; l++) {
                    f[i][j] = (f[i][j] + f[i - 1][j - l]) % MOD;
                }
            }
        }

        return f[n][target];
    }

    public int numRollsToTarget2(int n, int k, int target) {
        int[][] f = new int[2][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int a = i & 1, b = (i - 1) & 1;
            for (int j = 0; j <= target; j++) {
                f[a][j] = 0;
                for (int l = 1; l <= k && l <= j; l++) {
                    f[a][j] = (f[a][j] + f[b][j - l]) % MOD;
                }
            }
        }

        return f[n & 1][target];
    }

    public int numRollsToTarget3(int n, int k, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= 0; j--) {
                f[j] = 0;
                for (int l = 1; l <= k && l <= j; l++) {
                    f[j] = (f[j] + f[j - l]) % MOD;
                }
            }
        }

        return f[target];
    }
}
