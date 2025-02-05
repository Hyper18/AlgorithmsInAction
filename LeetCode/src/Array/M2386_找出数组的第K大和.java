package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/03/09
 * @file M2386_找出数组的第K大和.java
 * <p>
 * 思路
 * dfs，二分找到k个元素和不超过mid的子序列
 * 难点在于如何从原有的数组中抽离出每个不重复的子数组的和
 * cnt = k - 1去除空子序列
 * <p>
 * 待回看
 */
public class M2386_找出数组的第K大和 {
    int cnt;

    public long kSum(int[] nums, int k) {
        long sum = 0, high = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
            } else {
                nums[i] = -nums[i];
            }
            high += nums[i];
        }
        Arrays.sort(nums);

        long low = -1;
        while (low + 1 < high) {
            long mid = low + (high - low >> 1);
            cnt = k - 1;
            dfs(nums, 0, mid);
            if (cnt == 0) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return sum - high;
    }

    private void dfs(int[] nums, int i, long s) {
        if (cnt == 0 || i == nums.length || s < nums[i]) {
            return;
        }
        cnt--;
        dfs(nums, i + 1, s - nums[i]);
        dfs(nums, i + 1, s);
    }
}
