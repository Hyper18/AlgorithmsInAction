package DP;

/**
 * @author Hyper
 * @date 2022/03/08，2025/01/27
 * <p>
 * 贪心 + dp + 双指针 -- O(n)
 * 待回看
 */
public class Q45_跳跃游戏II {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j + nums[j] < i) {
                j++;
            }
            f[i] = f[j] + 1;
        }

        return f[n - 1];
    }
}
