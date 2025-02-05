package Greedy;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/10/21
 * @file M910_最小差值II.java
 * <p>
 * 思路
 * 贪心
 * 依次枚举i左侧的元素均+k，从i+1开始-k
 * <p>
 * 一开始想找avg，在avg下的+k，上的-k
 * 这样的写法无法通过 TC：[7,8,8,5,2] k = 4 output 6 ！= 5
 */
public class M910_最小差值II {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int mx = nums[n - 1], mn = nums[0];
        int ans = mx - mn;
        for (int i = 0; i < n - 1; i++) {
            mx = Math.max(nums[i] + k, nums[n - 1] - k);
            mn = Math.min(nums[i + 1] - k, nums[0] + k);
            ans = Math.min(ans, mx - mn);
        }

        return ans;
    }
}
