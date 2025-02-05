package DP.Knapsack;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/03/19
 * 发现这类题目题干信息都比较隐蔽
 * 需要考虑如何将原问题转化为背包问题
 * <p>
 * 在每一个数字前添加+或-，使式子的绝对值最小
 * 分为两堆，在一堆中找到背包所能装入的最大值
 * 用总和减去最大值 * 2
 */
public class Q1049_最后一块石头的重量II {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = Arrays.stream(stones).sum();
        int half = sum / 2;
        int[] dp = new int[half + 1];
        for (int i = 0; i < n; i++) {
            for (int j = half; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - 2 * dp[half];
    }
}
