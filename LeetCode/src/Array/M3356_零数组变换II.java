package Array;

/**
 * @author Hyperspace
 * @date 2025/05/20
 * @file M3356_零数组变换II.java
 * <p>
 * 思路
 * 二分+差分
 */
public class M3356_零数组变换II {
    private int[][] queries;

    public int minZeroArray(int[] nums, int[][] queries) {
        this.queries = queries;
        return binarySearch(nums);
    }

    private int binarySearch(int[] nums) {
        int n = queries.length;
        int low = 0, high = n;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (check(nums, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low <= n ? low : -1;
    }

    public boolean check(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            diff[l] += val;
            diff[r + 1] -= val;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (nums[i] > sum) {
                return false;
            }
        }

        return true;
    }
}
