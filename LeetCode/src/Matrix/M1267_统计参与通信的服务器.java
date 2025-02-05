package Matrix;

/**
 * @author Hyper
 * @date 2023/08/24
 * @file M1267_统计参与通信的服务器.java
 * <p>
 * 思路
 * 模拟，dfs
 */
public class M1267_统计参与通信的服务器 {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    boolean f = false;
                    for (int k = 0; k < m; k++) {
                        if (k != i && grid[k][j] == 1) {
                            f = true;
                            break;
                        }
                    }
                    for (int k = 0; k < n; k++) {
                        if (k != j && grid[i][k] == 1) {
                            f = true;
                            break;
                        }
                    }
                    ans += f ? 1 : 0;
                }
            }
        }

        return ans;
    }

    public int countServers2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] r = new int[m], c = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    r[i]++;
                    c[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (r[i] > 1 || c[j] > 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int countServers3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int cur = getServers(grid, i, j);
                    ans += cur == 1 ? 0 : cur;
                }
            }
        }

        return ans;
    }

    public int getServers(int[][] g, int x, int y) {
        if (x < 0 || x >= g.length || y < 0 || y >= g[0].length || g[x][y] == 0) {
            return 0;
        }
        g[x][y] = 0;
        int ans = 1;
        for (int i = 1; i <= Math.max(g.length, g[0].length); i++) {
            for (int[] d : dirs) {
                int nx = i * d[0] + x, ny = i * d[1] + y;
                ans += getServers(g, nx, ny);
            }
        }

        return ans;
    }
}
