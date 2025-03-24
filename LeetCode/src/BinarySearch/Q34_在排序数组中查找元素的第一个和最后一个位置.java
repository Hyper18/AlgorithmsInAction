package BinarySearch;

/**
 * @author Hyper
 * @date 2022/10/15，2025/03/24
 * <p>
 * 思路
 * 1. 裸二分2次 -- O(log_n)
 * 先找左边界，再找右边界，最后特判
 * 2. 闭区间二分 -- O(log_n)
 * 只需使用同一个 [low, high] 二分即可
 * 第一次调用找开始位置
 * 第二次调用找结束位置，
 * target' = target + 1 恰为此时大于target的元素的开始位置
 * 故 target' - 1 即为 target 的结束位置
 */
public class Q34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int st = binarySearchL(nums, target), ed = binarySearchR(nums, target);
        return st <= ed && (nums[st] == target && nums[ed] == target) ? new int[]{st, ed} : new int[]{-1, -1};
    }

    public int binarySearchL(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int binarySearchR(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + ((high - low + 1) >> 1);
            if (nums[mid] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    public int[] searchRange2(int[] nums, int target) {
        int n = nums.length;
        int st = binarySearch(nums, target);
        if (st == n || nums[st] != target) {
            return new int[]{-1, -1};
        }
        int ed = binarySearch(nums, target + 1) - 1;

        return new int[]{st, ed};
    }

    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
