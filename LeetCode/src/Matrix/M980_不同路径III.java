package Matrix;

/**
 * @author Hyper
 * @date 2023/08/04
 * @file M980_不同路径III.java
 * <p>
 * 思路
 * 回溯
 */
public class M980_不同路径III {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = 0, sx = 0, sy = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    cnt++;
                } else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }

        return dfs(grid, sx, sy, cnt + 1);
    }

    private int dfs(int[][] g, int x, int y, int cnt) {
        if (x < 0 || x >= g.length || y < 0 || y >= g[x].length || g[x][y] < 0) {
            return 0;
        }
        if (g[x][y] == 2) {
            return cnt == 0 ? 1 : 0;
        }
        g[x][y] = -1;
        int ans = dfs(g, x - 1, y, cnt - 1) + dfs(g, x, y - 1, cnt - 1) + dfs(g, x + 1, y, cnt - 1) + dfs(g, x, y + 1, cnt - 1);
        g[x][y] = 0;

        return ans;
    }
}
