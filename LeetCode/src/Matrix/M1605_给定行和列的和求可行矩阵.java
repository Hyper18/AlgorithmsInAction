package Matrix;

/**
 * @author Hyperspace
 * @date 2023/03/14
 * @file M1605_给定行和列的和求可行矩阵.java
 * <p>
 * 思路
 * 贪心，每次拿当前格可取的最多
 */
public class M1605_给定行和列的和求可行矩阵 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length, n = colSum.length;
        int[][] grid = new int[m][n];
        int i = 0, j = 0;
        while (i < m && j < n) {
            int val = Math.min(rowSum[i], colSum[j]);
            grid[i][j] = val;
            rowSum[i] -= val;
            colSum[j] -= val;
            if (rowSum[i] == 0) {
                i++;
            }
            if (colSum[j] == 0) {
                j++;
            }
        }

        return grid;
    }
}
