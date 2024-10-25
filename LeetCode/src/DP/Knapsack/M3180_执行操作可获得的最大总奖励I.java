package DP.Knapsack;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/10/25
 * @file M3180_执行操作可获得的最大总奖励I.java
 * <p>
 * 思路
 * 01背包
 * 背包容量为最大元素-1
 */
public class M3180_执行操作可获得的最大总奖励I {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int n = rewardValues.length, m = rewardValues[n - 1];
        int[] f = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= rewardValues[i]; j--) {
                if (rewardValues[i] > j - rewardValues[i]) {
                    f[j] = Math.max(f[j], f[j - rewardValues[i]] + rewardValues[i]);
                } else {
                    f[j] = Math.max(f[j], f[rewardValues[i] - 1] + rewardValues[i]);
                }
            }
        }

        return f[m - 1] + m;
    }
}
