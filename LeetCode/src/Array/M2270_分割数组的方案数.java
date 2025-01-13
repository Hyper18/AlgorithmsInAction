package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/01/13
 * @file M2270_分割数组的方案数.java
 * <p>
 * 思路
 * 模拟
 */
public class M2270_分割数组的方案数 {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long sum = Arrays.stream(nums).asLongStream().sum(), cur = 0;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            cur += nums[i];
            sum -= nums[i];
            if (cur >= sum) {
                ans++;
            }
        }

        return ans;
    }

    public int waysToSplitArray2(int[] nums) {
        int n = nums.length;
        long sum = 0, cur = 0;
        for (int num : nums) {
            sum += num;
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            cur += nums[i];
            sum -= nums[i];
            if (cur >= sum) {
                ans++;
            }
        }

        return ans;
    }

    public int waysToSplitArray3(int[] nums) {
        int n = nums.length;
        long sum = 0, cur = 0;
        for (int num : nums) {
            sum += num;
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            cur += nums[i];
            if (cur << 1 >= sum) {
                ans++;
            }
        }

        return ans;
    }
}
