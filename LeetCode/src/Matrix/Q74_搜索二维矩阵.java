package Matrix;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/10/15，2025/02/10
 * <p>
 * 思路
 * 逐行二分
 */
public class Q74_搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (binarySearch(row, target) >= 0) {
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (Arrays.binarySearch(row, target) >= 0) {
                return true;
            }
        }
        return false;
    }
}
