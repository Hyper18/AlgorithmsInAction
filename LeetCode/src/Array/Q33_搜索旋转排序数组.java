package Array;

/**
 * @author Hyperspace
 * @date 2022/10/09
 * <p>
 * 思路
 * key 找到分界点k的位置
 * 主要工作在寻找有序部分来应用二分
 * 可能的方式有：
 * 1. 与数组的最左端比较，若不小于最左的数，则左段是有序的；反之为右端
 * 2. 与数组的最右端比较，若不大于最右的数，则右段是有序的；反之为左端
 * <p>
 * 题目已经给定了复杂度O(log_n)
 * 其信号为指明需要使用的方法为二分
 * 否则直接O(n)遍历就o了
 */
public class Q33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[low]) {
                // 此时有序部分为[low, mid]
                if (target >= nums[low] && nums[mid] > target) {
                    // target在现区间左侧
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // 此时有序部分为[mid, high]
                if (target > nums[mid] && nums[high] >= target) {
                    // target在现区间右侧
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public int search2(int[] nums, int target) {
        int len = nums.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[high]) {
                // 此时有序部分为[mid, high]
                if (nums[mid] < target && target <= nums[high]) {
                    // target在现区间右侧
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // 此时有序部分为[low, mid]
                if (nums[low] <= target && target < nums[mid]) {
                    // target在现区间左侧
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
}
