package BinarySearch;

/**
 * @author Hyperspace
 * @date 2025/03/28
 * @file Q154_寻找旋转排序数组中的最小值II.java
 * <p>
 * 思路
 * 闭区间二分
 */
public class Q154_寻找旋转排序数组中的最小值II {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 2;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < nums[high + 1]) {
                high = mid - 1;
            } else if (nums[mid] > nums[high + 1]) {
                low = mid + 1;
            } else {
                high--;
            }
        }

        return nums[low];
    }
}
