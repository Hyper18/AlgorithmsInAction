package TwoPointer;

/**
 * @author Hyperspace
 * @date 2024/11/16
 * @file M3240_最少翻转次数使二进制矩阵回文II.java
 * <p>
 * 思路
 * 双指针 O(mn)
 * 分类讨论：
 * 1. m,n均为偶数，左上、左下、右上、右下一组一起操作
 * 2. m为奇数或n为奇数
 * 设k，c分别为操作数和1的数目
 * (1) m为奇数
 * grid[i][j] != grid[i][n−1−j]时，需要操作
 * (2) n为奇数
 * grid[i][j] != grid[m−i−1][j]时，需要操作
 * 3. m,n均为奇数，则矩阵中心必须为0
 */
public class M3240_最少翻转次数使二进制矩阵回文II {
    public int minFlips(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int x = 0, y = m - 1, t; x < y; x++, y--) {
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                t = grid[x][l] + grid[x][r] + grid[y][l] + grid[y][r];
                ans += Math.min(t, 4 - t);
            }
        }
        int k = 0, c = 0;
        if ((m & 1) != 0) {
            for (int x = m / 2, i = 0, j = n - 1; i < j; i++, j--) {
                k += grid[x][i] != grid[x][j] ? 1 : 0;
                c += grid[x][i];
            }
        }
        if ((n & 1) != 0) {
            for (int y = n / 2, i = 0, j = m - 1; i < j; i++, j--) {
                k += grid[i][y] != grid[j][y] ? 1 : 0;
                c += grid[i][y];
            }
        }
        ans += (c % 2 == 0 || k != 0) ? k : 2;
        if ((m & 1) != 0 && (n & 1) != 0 && grid[m / 2][n / 2] != 0) {
            ans++;
        }

        return ans;
    }
}
