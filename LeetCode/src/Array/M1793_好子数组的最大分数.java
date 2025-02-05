package Array;

/**
 * @author Hyper
 * @date 2024/03/19
 * @file M1793_好子数组的最大分数.java
 * <p>
 * 思路
 * 双指针
 * <p>
 * 待回看
 */
public class M1793_好子数组的最大分数 {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int ans = nums[k], idx = nums[k];
        for (int cnt = 0, i = k, j = k; cnt < n - 1; cnt++) {
            if (j == n - 1 || i > 0 && nums[i - 1] > nums[j + 1]) {
                idx = Math.min(idx, nums[--i]);
            } else {
                idx = Math.min(idx, nums[++j]);
            }
            ans = Math.max(ans, idx * (j - i + 1));
        }

        return ans;
    }
}
