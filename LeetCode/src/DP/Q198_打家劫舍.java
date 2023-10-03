package DP;

/**
 * @author Hyperspace
 * @date 2022/03/08，2023/09/16
 * <p>
 * 主要思考点在于找到状态转移方程
 * 另注意dp[1]的选取
 * 1. dp -- O(n)
 * 2. 状压dp -- O(n)
 */
public class Q198_打家劫舍 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1] > dp[0] ? nums[1] : dp[0];

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] > dp[i - 2] + nums[i] ? dp[i - 1] : dp[i - 2] + nums[i];
        }

        return dp[n - 1];
    }

    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int pre = nums[0];
        int curr = nums[1] > pre ? nums[1] : pre;

        for (int i = 2; i < n; i++) {
            int tmp = curr > pre + nums[i] ? curr : pre + nums[i];
            pre = curr;
            curr = tmp;
        }

        return curr;
    }
}
