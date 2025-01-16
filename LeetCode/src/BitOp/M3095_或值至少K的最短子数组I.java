package BitOp;

/**
 * @author Hyperspace
 * @date 2025/01/16
 * @file M3095_或值至少K的最短子数组I.java
 * <p>
 * 思路
 * 暴力，两层模拟
 * O(n^2)时间复杂度
 */
public class M3095_或值至少K的最短子数组I {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = 0, sum = 0;
            for (int j = i; j < n; j++) {
                sum |= nums[j];
                cur++;
                if (sum >= k) {
                    ans = Math.min(ans, cur);
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
