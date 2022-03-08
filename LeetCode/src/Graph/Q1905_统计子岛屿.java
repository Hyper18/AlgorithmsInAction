package Graph;

/**
 * @author Hyperspace
 * @date 2022/03/08
 * dfs
 * 相较于普通岛屿问题，还多了一层筛选条件：
 * 深搜中，子矩阵为陆地而父矩阵不为陆地，不为子岛屿
 * <p>
 * 看到一个也很好的思路
 * 可以先叠加两个矩阵，找到全为2的部分是为子岛屿
 */
public class Q1905_统计子岛屿 {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int n, m;
    private boolean isSubIsland;
    private final int LAND = 1;
    private final int ISLAND = 2;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == LAND) {
                    isSubIsland = true;
                    dfs(grid1, grid2, i, j);
                    ans += isSubIsland ? 1 : 0;
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] parentGrid, int[][] grid, int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] != LAND) {
            return;
        }
        if (parentGrid[row][col] != LAND) {
            isSubIsland = false;
        }

        grid[row][col] = ISLAND;
        for (int[] dir : dirs) {
            dfs(parentGrid, grid, row + dir[0], col + dir[1]);
        }
    }
}
