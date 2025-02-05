package Matrix;

/**
 * @author Hyper
 * @date 2024/08/29
 * @file M3142_判断矩阵是否满足条件.java
 */
public class M3142_判断矩阵是否满足条件 {
    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i != m - 1 && grid[i][j] != grid[i + 1][j]) || (j != n - 1 && grid[i][j] == grid[i][j + 1])) {
                    return false;
                }
            }
        }

        return true;
    }
}
