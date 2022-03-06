package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2022/03/06
 * <p>
 * 思路
 * 1. dfs
 * 如果单纯用设置visit标志位的方式，只能得到所有为陆地的网格
 * 因此将搜索得到的陆地的值标记为岛屿（2），从而达到只统计岛屿（>=1块的陆地方格）的目的
 * 2. bfs
 * 待优化
 */
public class Q200_岛屿数量 {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int n, m;
    private final char LAND = '1';
    private final char ISLAND = '2';

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == LAND) {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] != LAND) {
            return;
        }

        grid[row][col] = ISLAND;
        for (int[] dir : dirs) {
            int currRow = row + dir[0];
            int currCol = col + dir[1];
            dfs(grid, currRow, currCol);
        }
    }

    public int numIslands2(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == LAND) {
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        int row = pos[0];
                        int col = pos[1];
                        grid[row][col] = ISLAND;
                        for (int[] dir : dirs) {
                            int currRow = row + dir[0];
                            int currCol = col + dir[1];
                            if (currRow >= 0 && currRow < n && currCol >= 0 && currCol < m && grid[currRow][currCol] == LAND) {
                                queue.offer(new int[]{currRow, currCol});
                            }
                        }
                    }
                    ans++;
                }
            }
        }

        return ans;
    }
}
