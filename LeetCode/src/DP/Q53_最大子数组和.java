package DP;

/**
 * @author Hyper
 * @date 2022/02/11，2025/02/08
 * <p>
 * 思路
 * 1. brute force -- TLE O(n^2)
 * 2. DP -- O(n)
 * 3. 贪心 -- O(n)
 * 全局最优 = 局部最优下的最大连续和
 */
public class Q53_最大子数组和 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i, sum = 0; j < n; j++) {
                sum += nums[j];
                if (sum > ans) {
                    ans = sum;
                }
            }
        }

        return ans;
    }

    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int ans = nums[0];
        f[0] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, f[i]);
        }

        return ans;
    }

    public int maxSubArray3_0(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = nums[0], sum = 0;
        for (int num : nums) {
            sum += num;
            ans = Math.max(ans, sum);
            sum = Math.max(sum, 0);
        }

        return ans;
    }

    public int maxSubArray3_1(int[] nums) {
        int ans = nums[0], sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            ans = Math.max(sum, ans);
        }

        return ans;
    }
}
