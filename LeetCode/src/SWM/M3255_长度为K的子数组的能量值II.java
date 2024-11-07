package SWM;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2024/11/07
 * @file M3255_长度为K的子数组的能量值II.java
 * <p>
 * 同M3254，题目扩大了n的数据范围，卡纯暴力解法
 */
public class M3255_长度为K的子数组的能量值II {
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
