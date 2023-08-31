package Array;

import java.util.Arrays;

/**
 * @author Hyperspace
 * @date 2023/07/27
 * @file M2500_删除每行中的最大值.java
 * <p>
 * 思路
 * 模拟
 */
public class M2500_删除每行中的最大值 {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int[] a : grid) {
            Arrays.sort(a);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, grid[j][i]);
            }
            ans += max;
        }

        return ans;
    }
}
