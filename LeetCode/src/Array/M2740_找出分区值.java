package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/07/26
 * @file M2740_找出分区值.java
 * <p>
 * 思路
 * 一遍伪mid
 */
public class M2740_找出分区值 {
    public int findValueOfPartition(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, nums[i] - nums[i - 1]);
        }

        return ans;
    }
}
