package Matrix;

/**
 * @author Hyperspace
 * @date 2022/10/12
 * <p>
 * 思路
 * 二分
 * 逐行或逐列进行均可
 * 按行检索会更简单一些
 */
public class Q240_搜索二维矩阵II {
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
            int mid = low + (high - low) / 2;
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
}
