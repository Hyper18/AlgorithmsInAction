package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/02/26
 * <p>
 * 思路
 * 1. 暴力 -- O(n^2), 112 ms
 * 通过直接嵌套循环，枚举每一个元素作为子数组起始的情况
 * 并动态更新数组的最小长度
 * 注：这里注意下标（索引）和位置之间的转换
 * 2. 前缀和+二分查找 -- O(nlogn)
 * 来自官解，这题做的时候没想出来怎么直接用前缀和降维
 * 实际采用的方法是先计算前缀和，再通过二分查找的方式找到>=i的最小下标
 * 注：实际使用api需要处理二分查找未查找到（为负值）的情况
 * <p>
 * 小结：由于前缀和递增的特性，给二分查找提供了前置条件
 * 3. SVM -- O(n)
 * 不再反复从起始下标开始，而是通过窗口滑动降低复杂度
 */
public class Q209_长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length;
        int[] preSums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int curTarget = target + preSums[i - 1];
            int bound = Arrays.binarySearch(preSums, curTarget);
            bound = bound < 0 ? Math.abs(bound) - 1 : bound;
            if (bound <= n) {
                ans = Math.min(ans, bound - i + 1);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLen3(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        int start = 0;
        int end = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
