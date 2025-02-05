package Array;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/02/12，2024/09/08
 * @file M977_有序数组的平方.java
 */
public class M977_有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);

        return nums;
    }

    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = nums[l] * nums[l] > nums[r] * nums[r] ? nums[l] * nums[l++] : nums[r] * nums[r--];
        }

        return res;
    }

    public int[] sortedSquares3(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1, i = n;
        int[] res = new int[n];
        while (i-- > 0) {
            res[i] = nums[l] * nums[l] > nums[r] * nums[r] ? nums[l] * nums[l++] : nums[r] * nums[r--];
        }

        return res;
    }
}
