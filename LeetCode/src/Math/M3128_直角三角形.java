package Math;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/08/02
 * @file M3128_直角三角形.java
 * <p>
 * 思路
 * 数学
 * (rowSum−1) * (colSum−1)
 */
public class M3128_直角三角形 {
    public long numberOfRightTriangles(int[][] grid) {
        int n = grid[0].length;
        int[] colSum = new int[n];
        Arrays.fill(colSum, -1);
        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                colSum[j] += row[j];
            }
        }
        long ans = 0;
        for (int[] row : grid) {
            int rowSum = Arrays.stream(row).sum() - 1;
            for (int j = 0; j < n; j++) {
                if (row[j] == 1) {
                    ans += (long) rowSum * colSum[j];
                }
            }
        }

        return ans;
    }
}
