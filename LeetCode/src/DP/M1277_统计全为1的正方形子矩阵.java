package DP;

/**
 * @author Hyper
 * @date 2025/08/20
 * @file M1277_统计全为1的正方形子矩阵.java
 * <p>
 * 思路
 * DP
 */
public class M1277_统计全为1的正方形子矩阵 {
    class Solution1_0 {
        public int countSquares(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] f = new int[m + 1][n + 1];
            int ans = 0;
            for (int i = m; i > 0; i--) {
                for (int j = n; j > 0; j--) {
                    if (matrix[i - 1][j - 1] == 0) {
                        continue;
                    }
                    ans += f[i - 1][j - 1] = Math.min(Math.min(f[i][j], f[i][j - 1]), f[i - 1][j]) + 1;
                }
            }

            return ans;
        }
    }

    class Solution1_1 {
        public int countSquares(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int ans = 0;
            for (int i = m - 1; i >= 0; i--) {
                int[] row = matrix[i];
                for (int j = n - 1; j >= 0; j--) {
                    if (row[j] != 0 && i < m - 1 && j < n - 1) {
                        row[j] += Math.min(Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]), row[j + 1]);
                    }
                    ans += row[j];
                }
            }

            return ans;
        }
    }
}
