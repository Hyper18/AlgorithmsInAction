package BinarySearch;

/**
 * @author Hyper
 * @date 2022/10/11
 * <p>
 * 思路
 * 裸二分，可以用模板套出两种写法
 */
public class Q162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
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
}
