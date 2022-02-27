package BinarySearch;

/**
 * @author Hyperspace
 * @date 2022/02/27
 */
public class Model {
    private int search(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = nums[mid];
            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return low;
    }

    private int search2(int[] nums, int target) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int midVal = nums[mid];
            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid;
            } else {
                return mid;
            }
        }

        return low;
    }
}
