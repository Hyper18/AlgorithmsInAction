package DP.Knapsack;

import java.util.List;

/**
 * @author Hyperspace
 * @date 2025/01/21
 * @file M2218_从栈中取出K个硬币的最大面值和.java
 * <p>
 * 思路
 * 前缀和+分组背包
 * <p>
 * 1. 状态表示
 * 集合：f[i]为考虑前i组物品背包体积为j的方案
 * 属性：Max
 * 2. 状态计算
 * f[i] = max(f[i], f[i - (j + 1)] + preSum)
 */
public class M2218_从栈中取出K个硬币的最大面值和 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] f = new int[k + 1];
        for (List<Integer> p : piles) {
            for (int i = k; i >= 0; i--) {
                int s = p.size(), w = 0;
                for (int j = 0; j < Math.min(s, i); j++) {
                    w += p.get(j);
                    f[i] = Math.max(f[i], f[i - j - 1] + w);
                }
            }
        }

        return f[k];
    }
}
