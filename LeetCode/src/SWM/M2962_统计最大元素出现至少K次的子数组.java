package SWM;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2025/04/29
 * @file M2962_统计最大元素出现至少K次的子数组.java
 * <p>
 * 思路
 * SWM
 * 一开始看成子数组中的最大值
 * 实际应为原始数组中的最大值
 */
public class M2962_统计最大元素出现至少K次的子数组 {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        int mx = Arrays.stream(nums).max().getAsInt();
        for (int l = 0, r = 0, cnt = 0; r < n; r++) {
            if (nums[r] == mx) {
                cnt++;
            }
            while (cnt >= k) {
                ans += n - r;
                if (nums[l++] == mx) {
                    cnt--;
                }
            }
        }

        return ans;
    }

    public long countSubarrays2(int[] nums, int k) {
        int n = nums.length;
        int mx = 0;
        for (int num : nums) {
            if (num > mx) {
                mx = num;
            }
        }
        long ans = 0;
        for (int l = 0, r = 0, cnt = 0; r < n; r++) {
            if (nums[r] == mx) {
                cnt++;
            }
            while (cnt >= k) {
                if (nums[l++] == mx) {
                    cnt--;
                }
            }
            ans += l;
        }

        return ans;
    }
}
