package DP;

/**
 * @author Hyperspace
 * @date 2023/07/20
 * @file M918_环形子数组的最大和.java
 * <p>
 * 思路
 * DP，参Q53
 * 分类讨论子数组不成环和成环的情况
 */
public class M918_环形子数组的最大和 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        int maxSum = f[0], minSum = 0, sum = f[0];
        for (int i = 1; i < n; i++) {
            f[i] = nums[i] + Math.max(f[i - 1], 0);
            maxSum = Math.max(f[i], maxSum);
            sum += nums[i];
        }
        for (int i = 1; i < n - 1; i++) {
            f[i] = nums[i] + Math.min(0, f[i - 1]);
            minSum = Math.min(f[i], minSum);
        }

        return Math.max(maxSum, sum - minSum);
    }

    public int maxSubarraySumCircular2(int[] nums) {
        int n = nums.length;
        int cur = nums[0], maxSum = cur, minSum = 0, sum = cur;
        for (int i = 1; i < n; i++) {
            cur = nums[i] + Math.max(cur, 0);
            maxSum = Math.max(cur, maxSum);
            sum += nums[i];
        }
        for (int i = 1; i < n - 1; i++) {
            cur = nums[i] + Math.min(0, cur);
            minSum = Math.min(cur, minSum);
        }

        return Math.max(maxSum, sum - minSum);
    }

    public int maxSubarraySumCircular3(int[] nums) {
        int sum = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
            sum += num;
        }

        return maxSum > 0 ? Math.max(maxSum, sum - minSum) : maxSum;
    }
}
