package Greedy;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2023/09/19
 * @file M2560_打家劫舍IV.java
 * <p>
 * 思路
 * 二分+贪心
 * 注意此二分为左侧为开区间时使用的模板
 */
public class M2560_打家劫舍IV {
    public int minCapability(int[] nums, int k) {
        int r = Arrays.stream(nums).max().getAsInt();
        return binarySearch(nums, k, 0, r);
    }

    private int binarySearch(int[] nums, int k, int l, int r) {
        while (l + 1 < r) {
            int m = l + ((r - l) >> 1);
            if (check(nums, k, m)) {
                r = m;
            } else {
                l = m;
            }
        }

        return r;
    }

    private boolean check(int[] nums, int k, int m) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= m) {
                cnt++;
                i++;
            }
        }

        return cnt >= k;
    }
}
