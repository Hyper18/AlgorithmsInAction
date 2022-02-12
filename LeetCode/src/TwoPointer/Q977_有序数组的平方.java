package TwoPointer;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2022/02/12
 * 思路
 * 1. 快排 -- O(nlogn)
 * 2. 双指针法 -- O(n)
 * 有序，平方后两头大
 */
public class Q977_有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);

        return nums;
    }

    public int[] sortedSquares2(int[] nums) {
        int len = nums.length;
        int p1 = 0;
        int p2 = len - 1;
        int[] ans = new int[len];
        for (int idx = len - 1; idx >= 0; idx--) {
            ans[idx] = nums[p1] * nums[p1] > nums[p2] * nums[p2] ? nums[p1] * nums[p1++] : nums[p2] * nums[p2--];
        }

        return ans;
    }
}
