package BinarySearch;

/**
 * @author Hyper
 * @date 2022/10/28，2025/03/28
 * <p>
 * 思路
 * 二分
 * <p>
 * 一遍过，跟之前题思路很像
 * 都是二分，再找不完全有序中的有序部分
 * 每次将当前的右边界作为 target
 * (1) 右边是有序部分，移动左边界
 * 此时，不会包含 mid 所在的位置
 * (2) 左边是有序部分，移动右边界
 * 此时，有可能最小值落在 mid 所在的位置
 * <p>
 * 2. 闭区间二分
 * 两种写法
 */
public class Q153_寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return nums[low];
    }

    public int findMin2_0(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1, ans = nums[0];
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            ans = Math.min(ans, nums[mid]);
            if (nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int findMin2_1(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (mid == n - 1 || nums[mid] < nums[n - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return nums[low];
    }
}
