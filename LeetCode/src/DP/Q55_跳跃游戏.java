package DP;

/**
 * @author Hyper
 * @date 2022/03/08
 * <p>
 * 1. dp
 * 检查右边界是否越过数组长度
 * 若超过，返回true
 * 最后的ret表示当前数组长度为1的情况
 * 即一定能够达到数组最后
 * 2. 贪心
 */
public class Q55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] < i) {
                return false;
            }
            dp[i] = dp[i - 1] > nums[i] + i ? dp[i - 1] : nums[i] + i;
            if (dp[i] >= n - 1) {
                return true;
            }
        }

        return true;
    }

    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (i <= right) {
                right = right > nums[i] + i ? right : nums[i] + i;
                if (right >= n - 1) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }
}
