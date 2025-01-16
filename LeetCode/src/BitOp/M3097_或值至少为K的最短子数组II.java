package BitOp;

/**
 * @author Hyperspace
 * @date 2025/01/16
 * @file M3097_或值至少为K的最短子数组II.java
 * <p>
 * 思路@灵茶山艾府
 * 位运算+SWM
 * O(n)时间复杂度
 */
public class M3097_或值至少为K的最短子数组II {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, sum = 0, ans = Integer.MAX_VALUE, bottom = 0;
        while (r < n) {
            sum |= nums[r];
            while (l <= r && (nums[l] | sum) >= k) {
                ans = Math.min(ans, r - l + 1);
                l++;
                if (bottom < l) {
                    for (int i = r - 1; i >= l; i--) {
                        nums[i] |= nums[i + 1];
                    }
                    bottom = r;
                    sum = 0;
                }
            }
            r++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int minimumSubarrayLength2(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, sum = 0, ans = Integer.MAX_VALUE;
        while (r < n) {
            sum |= nums[r];
            if (sum >= k) {
                ans = Math.min(ans, r - l + 1);
                sum = 0;
                for (l = r; l >= 0 && r - l + 1 < ans; l--) {
                    sum |= nums[l];
                    if (sum >= k) {
                        ans = Math.min(ans, r - l + 1);
                    }
                }
            }
            r++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
