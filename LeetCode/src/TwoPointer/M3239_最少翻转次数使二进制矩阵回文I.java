package TwoPointer;

/**
 * @author Hyperspace
 * @date 2024/11/15
 * @file M3239_最少翻转次数使二进制矩阵回文I.java
 */
public class M3239_最少翻转次数使二进制矩阵回文I {
    public int minFlips(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                if (grid[i][l++] != grid[i][r--]) {
                    cnt1++;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int l = 0, r = m - 1;
            while (l < r) {
                if (grid[l++][j] != grid[r--][j]) {
                    cnt2++;
                }
            }
        }

        return Math.min(cnt1, cnt2);
    }

    public int minFlips2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                if ((grid[i][l++] ^ grid[i][r--]) != 0) {
                    cnt1++;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int l = 0, r = m - 1;
            while (l < r) {
                if ((grid[l++][j] ^ grid[r--][j]) != 0) {
                    cnt2++;
                }
            }
        }

        return Math.min(cnt1, cnt2);
    }
}
