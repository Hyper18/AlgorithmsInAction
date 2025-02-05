package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hyper
 * @date 2022/03/10
 * <p>
 * 1. 朴素bfs
 * 被全1矩阵测试用例制裁。。
 * 2. 优化的bfs
 * 使用超级源点，先将所有的0入队
 * 再逐一进行搜索 -- 中心开花，逐一扩散
 */
public class Q542_01矩阵 {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = mat[i][j] == 0 ? mat[i][j] : bfs(mat, i, j);
            }
        }

        return res;
    }

    private int bfs(int[][] grid, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{row, col, 0});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            if (grid[pos[0]][pos[1]] == 0) {
                return pos[2];
            }
            for (int[] dir : dirs) {
                int currRow = pos[0] + dir[0];
                int currCol = pos[1] + dir[1];
                if (isIn(currRow, currCol) && !visited[currRow][currCol]) {
                    queue.offer(new int[]{currRow, currCol, pos[2] + 1});
                    visited[currRow][currCol] = true;
                }
            }
        }

        return -1;
    }

    private boolean isIn(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    public int[][] updateMatrix2(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int currRow = pos[0] + dir[0];
                int currCol = pos[1] + dir[1];
                if (isIn(currRow, currCol) && !visited[currRow][currCol]) {
                    // key step
                    res[currRow][currCol] = res[pos[0]][pos[1]] + 1;
                    queue.offer(new int[]{currRow, currCol});
                    visited[currRow][currCol] = true;
                }
            }
        }

        return res;
    }
}
