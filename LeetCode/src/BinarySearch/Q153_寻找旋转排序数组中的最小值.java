package BinarySearch;

/**
 * @author Hyperspace
 * @date 2022/10/28
 * <p>
 * 思路
 * 一遍过，跟之前题思路很像
 * 都是二分，再找不完全有序中的有序部分
 * 每次将当前的右边界作为target
 * 1. 右边是有序部分，移动左边界
 * 此时，不会包含mid所在的位置
 * 2. 左边是有序部分，移动右边界
 * 此时，有可能最小值落在mid所在的位置
 */
public class Q153_寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }
}
