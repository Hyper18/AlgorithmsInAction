package TwoPointer;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/06/29
 * @file M1498_满足条件的子序列数目.java
 * <p>
 * 思路
 * 相向双指针
 */
public class M1498_满足条件的子序列数目 {
    private final int MOD = (int) 1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] powers = new int[n];
        powers[0] = 1;
        for (int i = 1; i < n; i++) {
            powers[i] = (powers[i - 1] * 2) % MOD;
        }
        long ans = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                ans = (ans + powers[r - l]) % MOD;
                l++;
            }
        }

        return (int) ans;
    }
}
