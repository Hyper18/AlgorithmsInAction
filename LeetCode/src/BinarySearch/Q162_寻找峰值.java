package BinarySearch;

/**
 * @author Hyper
 * @date 2022/10/11，2023/12/18，2025/03/27
 * <p>
 * 思路
 * 二分裸
 * 可用模板套出3种写法
 */
public class Q162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public int findPeakElement2(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] > nums[mid - 1]) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    public int findPeakElement3(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (mid == n - 1 || nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
