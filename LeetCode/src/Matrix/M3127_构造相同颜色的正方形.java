package Matrix;

/**
 * @author Hyper
 * @date 2024/08/31
 * @file M3127_构造相同颜色的正方形.java
 */
public class M3127_构造相同颜色的正方形 {
    public boolean canMakeSquare(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char c = grid[i][j];
                int cnt = 0;
                if (c == grid[i + 1][j]) {
                    cnt++;
                }
                if (c == grid[i][j + 1]) {
                    cnt++;
                }
                if (c == grid[i + 1][j + 1]) {
                    cnt++;
                }
                if (cnt != 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
