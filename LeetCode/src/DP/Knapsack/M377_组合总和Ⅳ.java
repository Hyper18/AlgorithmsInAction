package DP.Knapsack;

/**
 * @author Hyper
 * @date 2024/04/22
 * @file M377_组合总和Ⅳ.java
 * <p>
 * 思路
 * 朴素背包
 * 先枚举背包大小，再枚举体积
 */
public class M377_组合总和Ⅳ {
    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                f[i] += i >= num ? f[i - num] : 0;
            }
        }

        return f[target];
    }
}
