package BinarySearch;

/**
 * @author Hyper
 * @date 2024/04/09，2025/03/24
 * @file M2529_正整数和负整数的最大计数.java
 * <p>
 * 思路
 * 1. 模拟 -- O(n)
 * 裸，不想写普通计数了，整个活
 * 2. 闭区间二分 -- O(log_n)
 * 找0的开始位置和结束位置，记作下标 i, j
 * 确定后，所有 i 左侧的均为负数，j 右侧的均为正数
 * 即答案为 ans = max([(i - 1) - 0] + 1, [(n - 1) - (j + 1)] + 1)
 */
public class M2529_正整数和负整数的最大计数 {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int num : nums) {
            ans += num > 0 ? 1 : 0;
            n -= num == 0 ? 1 : 0;
        }

        return Math.max(ans, n - ans);
    }

    public int maximumCount2(int[] nums) {
        int n = nums.length;
        int st = binarySearch(nums, 0), ed = binarySearch(nums, 1) - 1;

        return Math.max(st, n - 1 - ed);
    }

    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length;
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
