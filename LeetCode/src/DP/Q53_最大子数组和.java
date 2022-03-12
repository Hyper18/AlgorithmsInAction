package DP;

/**
 * @author Hyperspace
 * @date 2022/02/11
 * <p>
 * 思路
 * 1. 暴力 -- 超时。。时间复杂度O(n^2)
 * 2./3. 贪心法 -- 时间复杂度O(n)
 * 全局最优 = 局部最优下的最大连续和
 * 4. 动态规划 -- 时间复杂度O(n)
 * 第一步骤：定义数组元素的含义，如:用一个数组保存历史数组（1-dim）
 * 第二步骤：找出数组元素之间的关系式
 * 第三步骤：找出初始值
 * <p>
 * 注：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class Q53_最大子数组和 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            ans = Math.max(ans, sum);
            sum = sum > 0 ? sum : 0;
        }

        return ans;
    }

    public int maxSubArray3(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public int maxSubArray3_2(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = max(sum + num, num);
            ans = max(ans, sum);
        }
        return ans;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public int maxSubArray4(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int ans = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] + nums[i] > nums[i]) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            ans = dp[i] > ans ? dp[i] : ans;
        }
        return ans;
    }
}
