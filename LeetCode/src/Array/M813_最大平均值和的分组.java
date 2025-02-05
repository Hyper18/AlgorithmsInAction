package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/11/28
 * @file M813_最大平均值和的分组.java
 * <p>
 * 思路
 * 一、 不考虑相邻情况，贪心
 * 二、 考虑相邻请情况，前缀和 + DP
 * 1. 状态表示
 * 集合：f[i][j]表示前i个元素
 * 属性：max
 * 2. 状态计算
 * f[i][j] = max(f[i][j], f[l - 1][j - 1] + (pre[i] - pre[l - 1]) / (i - l + 1))
 */
public class M813_最大平均值和的分组 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        double ans = 0;
        int i = n - 1;
        while (k > 0) {
            ans += nums[i];
            k--;
            i--;
        }
        ans += (double) Arrays.stream(nums, 0, i).sum() / (i + 1);

        return ans;
    }

    public double largestSumOfAverages2(int[] nums, int k) {
        int n = nums.length;
        double[] pre = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        double[][] f = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                if (j == 1) {
                    f[i][j] = pre[i] / i;
                } else {
                    for (int l = 2; l <= i; l++) {
                        f[i][j] = Math.max(f[i][j], f[l - 1][j - 1] + (pre[i] - pre[l - 1]) / (i - l + 1));
                    }
                }
            }
        }

        return f[n][k];
    }
}
