package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/11/06
 * @file M3254_长度为K的子数组的能量值I.java
 * <p>
 * 思路
 * SWM
 * 固定左端点
 */
public class M3254_长度为K的子数组的能量值I {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) {
            return nums;
        }
        int[] res = new int[n - k + 1];
        Arrays.fill(res, -1);
        int cnt = 1;
        for (int l = 0, r = l + 1; r < n; r++) {
            if (nums[r] - nums[r - 1] == 1) {
                if (++cnt == k) {
                    res[r - k + 1] = nums[r];
                    cnt--;
                    l++;
                }
            } else {
                cnt = 1;
                l = r;
            }

        }

        return res;
    }
}
