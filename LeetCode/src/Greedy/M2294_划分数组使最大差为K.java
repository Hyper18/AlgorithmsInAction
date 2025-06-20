package Greedy;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/06/19
 * @file M2294_划分数组使最大差为K.java
 * <p>
 * 思路
 * 排序+贪心
 * 很容易想到先排序，依次截取子数组
 */
public class M2294_划分数组使最大差为K {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 1;
        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] - nums[l] <= k) {
                continue;
            }
            ans++;
            l = r;
        }

        return ans;
    }
}
