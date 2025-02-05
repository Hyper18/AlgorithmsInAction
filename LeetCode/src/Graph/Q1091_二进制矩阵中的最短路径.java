package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hyper
 * @date 2022/03/10
 * <p>
 * 思路：bfs
 * 8个方向实际上给定了可能行进的方向
 * 注意考虑两种特殊情况：
 * 1. 矩阵仅含单元素且为0
 * 2. 矩阵首尾任一不为0
 */
public class Q1091_二进制矩阵中的最短路径 {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    int n;

    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        if (n == 1 && grid[0][0] == 0) {
            return 1;
        }
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;
        int[] pos;
        while (!queue.isEmpty()) {
            pos = queue.poll();
            for (int[] dir : dirs) {
                int currRow = pos[0] + dir[0];
                int currCol = pos[1] + dir[1];
                if (currRow == n - 1 && currCol == n - 1) {
                    return pos[2] + 1;
                }
                if (isIn(currRow, currCol) && grid[currRow][currCol] == 0) {
                    queue.offer(new int[]{currRow, currCol, pos[2] + 1});
                    grid[currRow][currCol] = 1;
                }
            }
        }

        return -1;
    }

    private boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
