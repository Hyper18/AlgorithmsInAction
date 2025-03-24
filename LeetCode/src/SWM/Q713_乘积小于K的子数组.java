package SWM;

/**
 * @author Hyper
 * @date 2025/03/24
 * @file Q713_乘积小于K的子数组.java
 * <p>
 * 思路
 * 同向SWM -- O(n)
 */
public class Q713_乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) {
            return 0;
        }
        int n = nums.length;
        int ans = 0, sum = 1;
        for (int l = 0, r = 0; r < n; r++) {
            sum *= nums[r];
            while (sum >= k) {
                sum /= nums[l++];
            }
            ans += r - l + 1;
        }

        return ans;
    }
}
