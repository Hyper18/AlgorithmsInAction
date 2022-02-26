package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/02/26
 * <p>
 * 思路
 * 1. 前缀和 -- O(n)
 * 注：数组中心下标位于最左端约定返回-1
 */
public class Q724_寻找数组的中心下标 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int total = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }

        return -1;
    }
}
