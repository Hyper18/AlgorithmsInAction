package BFS_DFS;

/**
 * @author Hyperspace
 * @date 2022/02/17
 * <p>
 * 思路
 * 记忆化搜索
 */
public class M688_骑士在棋盘上的概率 {
    private static int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    int n, k;
    double[][][] cache;

    public double knightProbability(int n, int k, int row, int col) {
        this.n = n;
        this.k = k;
        this.cache = new double[k + 1][n + 1][n + 1];
        return DFSTraverse(row, col, 0) / Math.pow(dirs.length, k);
    }

    double DFSTraverse(int row, int col, int depth) {
        if (depth == k) {
            return 1;
        }

        if (cache[depth][row][col] != 0) {
            return cache[depth][row][col];

        }
        double res = 0;
        for (int[] dir : dirs) {
            int currRow = row + dir[0], currCol = col + dir[1];
            if (currRow < 0 || currRow >= n || currCol < 0 || currCol >= n) {
                continue;
            }
            res += DFSTraverse(currRow, currCol, depth + 1);
        }
        cache[depth][row][col] = res;

        return res;
    }
}
