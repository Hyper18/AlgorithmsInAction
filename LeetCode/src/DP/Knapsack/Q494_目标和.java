package DP.Knapsack;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/03/19
 * <p>
 * 首先考虑转化问题
 * target == pack size
 * 按题意，初始化为恰等于的情况
 * 从而将题目转化为01背包问题
 */
public class Q494_目标和 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int diff = sum - target;
        if (diff % 2 != 0 || diff < 0) {
            return 0;
        }
        int half = diff / 2;
        int[] dp = new int[half + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = half; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[half];
    }
}
