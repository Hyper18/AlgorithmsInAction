package Graph;

/**
 * @author Hyperspace
 * @date 2022/03/08
 * 如果仅存在一行或一列，一定没有封闭岛屿，直接返回
 * 对大于2*2的矩阵，遍历时去掉四周
 * <p>
 * 重点在于dfs判断时，
 * 应当对深搜的四个方向均为非陆地时，才为封闭
 */
public class Q1254_统计封闭岛屿的数目 {
    private final int LAND = 0;
    private final int ISLAND = 2;
    static int n, m;

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        if (m == 1 || n == 1) {
            return ans;
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == LAND && dfs(grid, i, j)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }
        if (grid[row][col] != LAND) {
            return true;
        }
        grid[row][col] = ISLAND;
        boolean north = dfs(grid, row + 1, col);
        boolean south = dfs(grid, row - 1, col);
        boolean east = dfs(grid, row, col + 1);
        boolean west = dfs(grid, row, col - 1);

        return north && south && east && west;
    }
}
