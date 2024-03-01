package BinarySearch;

/**
 * @author Hyperspace
 * @date 2023/12/18
 * @file M162_寻找峰值.java
 * <p>
 * 思路
 * 二分，找递增方向
 */
public class M162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
