package DP;

/**
 * @author Hyper
 * @date 2022/03/08
 * <p>
 * 贪心 + dp + 双指针 -- O(n)
 * 待回看
 */
public class Q45_跳跃游戏II {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j + nums[j] < i) {
                j++;
            }
            dp[i] = dp[j] + 1;
        }

        return dp[n - 1];
    }
}
