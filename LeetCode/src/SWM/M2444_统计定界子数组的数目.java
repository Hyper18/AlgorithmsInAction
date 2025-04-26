package SWM;

/**
 * @author Hyperspace
 * @date 2025/04/26
 * @file M2444_统计定界子数组的数目.java
 * <p>
 * 思路@灵茶山艾府
 * SWM
 * 固定右端点，累计可行左端点下的子数组个数
 */
public class M2444_统计定界子数组的数目 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long ans = 0;
        int mn = -1, mx = -1, idx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == minK) {
                mn = i;
            }
            if (nums[i] == maxK) {
                mx = i;
            }
            if (nums[i] < minK || nums[i] > maxK) {
                idx = i;
            }
            ans = Math.max(Math.min(mn, mx) - idx, 0);
        }

        return ans;
    }
}
