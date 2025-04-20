package BinarySearch;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2025/03/24，2025/04/19
 * @file M2563_统计公平数对的数目.java
 * <p>
 * 思路
 * 排序+开区间二分 -- O(nlog_n)
 * 很容易想到暴力的做法，但是 O(n^2)的
 * 故思路转变为先固定一端，二分找另一端
 * 假设此时遍历到 nums[i]
 * 则当前满足要求的区间为 [lower - nums[i], upper - nums[i]]
 * 只需找到区间的开始和结束位置，并将遍历的结果加和
 * 由于区间可能会包含本身（下标i所在的位置），需要特判
 * 再加上统计的数对没有区分 (a, b) 和 (b, a)
 * 因此最终答案为 sum[ed - st + (st <= i && i <= ed ? 0 : 1)] / 2
 */
public class M2563_统计公平数对的数目 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int st = binarySearch(nums, lower - nums[i]), ed = binarySearch(nums, upper - nums[i] + 1) - 1;
            if (st <= ed) {
                ans += ed - st + (st <= i && i <= ed ? 0 : 1);
            }
        }

        return ans >> 1;
    }

    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
