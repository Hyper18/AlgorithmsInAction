package BinarySearch;

/**
 * @author Hyper
 * @date 2022/10/15
 * <p>
 * 思路
 * 裸二分2次
 * 先找左边界，再找右边界，最后特判
 */
public class Q34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = binarySearchL(nums, 0, n - 1, target);
        int r = binarySearchR(nums, 0, n - 1, target);

        return l <= r && (nums[l] == target && nums[r] == target) ? new int[]{l, r} : new int[]{-1, -1};
    }

    public int binarySearchL(int[] a, int l, int r, int t) {
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (a[m] >= t) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public int binarySearchR(int[] a, int l, int r, int t) {
        while (l < r) {
            int m = l + ((r - l + 1) >> 1);
            if (a[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        return r;
    }
}
