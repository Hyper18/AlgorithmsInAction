package Graph;

/**
 * @author Hyper
 * @date 2022/03/08
 * <p>
 * dfs
 */
public class Q695_岛屿的最大面积 {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private final int LAND = 1;
    private final int ISLAND = 2;
    static int n, m, cnt;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == LAND) {
                    cnt = 0;
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != LAND) {
            return 0;
        }

        grid[row][col] = ISLAND;
        cnt++;
        for (int[] dir : dirs) {
            int currRow = row + dir[0];
            int currCol = col + dir[1];
            dfs(grid, currRow, currCol);
        }

        return cnt;
    }

    private int dfs2(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != LAND) {
            return 0;
        }

        grid[row][col] = ISLAND;
        int ans = 1;
        for (int[] dir : dirs) {
            int currRow = row + dir[0];
            int currCol = col + dir[1];
            ans += dfs2(grid, currRow, currCol);
        }

        return ans;
    }
}
