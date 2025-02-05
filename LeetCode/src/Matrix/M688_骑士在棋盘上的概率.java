package Matrix;

/**
 * @author Hyper
 * @date 2024/12/07
 * @file M688_骑士在棋盘上的概率.java
 * <p>
 * 思路
 * dfs+记忆化搜索
 */
public class M688_骑士在棋盘上的概率 {
    private final int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    private double[][][] cache;
    private int n, k;

    public double knightProbability(int n, int k, int row, int col) {
        this.n = n;
        this.k = k;
        this.cache = new double[k + 1][n + 1][n + 1];
        return dfs(row, col, 0) / Math.pow(dirs.length, k);
    }

    double dfs(int x, int y, int d) {
        if (d == k) {
            return 1;
        }
        if (cache[d][x][y] != 0) {
            return cache[d][x][y];
        }
        double ans = 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }
            ans += dfs(nx, ny, d + 1);
        }

        cache[d][x][y] = ans;
        return ans;
    }
}
