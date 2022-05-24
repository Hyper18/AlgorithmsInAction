package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2022/02/12
 * <p>
 * 思路
 * 1. DFS -- 时间复杂度O(mn)
 * 2. DFS -- 时间复杂度O(mn)
 * 从网格边界上的每个陆地单元格开始
 * 依次遍历行、列，注意边界上的一定不为飞地可省
 * 最后嵌套循环输出仍未被访问的飞地数目
 */
public class M1020_飞地的数量 {

    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;
    private boolean[][] isVisited;

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];

        // Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                isVisited[i][0] = true;
                queue.offer(new int[]{i, 0});
            }
            if (grid[i][n - 1] == 1) {
                isVisited[i][n - 1] = true;
                queue.offer(new int[]{i, n - 1});
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (grid[0][j] == 1) {
                isVisited[0][j] = true;
                queue.offer(new int[]{0, j});
            }
            if (grid[m - 1][j] == 1) {
                isVisited[m - 1][j] = true;
                queue.offer(new int[]{m - 1, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currRow = cell[0];
            int currCol = cell[1];
            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n && grid[nextRow][nextCol] == 1 && !isVisited[nextRow][nextCol]) {
                    isVisited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }

        int enclaves = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    public int numEnclaves2(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            DFSTraverse(grid, i, 0);
            DFSTraverse(grid, i, n - 1);
        }
        for (int j = 1; j < n; j++) {
            DFSTraverse(grid, 0, j);
            DFSTraverse(grid, m - 1, j);
        }

        int enclaves = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;
    }

    public void DFSTraverse(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] != 1 || isVisited[row][col]) {
            return;
        }
        isVisited[row][col] = true;
        for (int[] dir : dirs) {
            DFSTraverse(grid, row + dir[0], col + dir[1]);
        }
    }
}
