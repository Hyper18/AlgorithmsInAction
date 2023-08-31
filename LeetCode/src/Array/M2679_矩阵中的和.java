package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2023/07/08
 * @file M2679_矩阵中的和.java
 */
public class M2679_矩阵中的和 {
    public int matrixSum(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        for (int[] a : nums) {
            Arrays.sort(a);
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int t = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                if (nums[i][j] > t) {
                    t = nums[i][j];
                }
            }
            ans += t;
        }

        return ans;
    }
}
