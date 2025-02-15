package Matrix;

/**
 * @author Hyper
 * @date 2025/02/15
 * @file M1706_球会落何处.java
 * <p>
 * 思路
 * 模拟
 */
public class M1706_球会落何处 {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int x = 0, y = i;
            while (x < m && y >= 0 && y < n) {
                if ((y == n - 1 || grid[x][y + 1] == -1) && grid[x][y] == 1 || (y == 0 || grid[x][y - 1] == 1) && grid[x][y] == -1) {
                    res[i] = -1;
                    break;
                }
                y += grid[x++][y] == 1 ? 1 : -1;
            }
            if (x == m) {
                res[i] = y;
            }
        }

        return res;
    }
}
