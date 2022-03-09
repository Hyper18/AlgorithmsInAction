package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2022/03/09
 * <p>
 * 1. 朴素多源bfs（超时）
 * 最初思路考虑当前地块为海洋时，广搜直到找到最近的陆地
 * 测试案例中有一个超稀疏图（陆地地块远小于海洋地块），此时复杂度为 O(n ^ 4)
 * 2. 优化的bfs -- O(n ^ 2)
 * @Sweetiee 思路
 * 考虑当前地块为陆地时，广搜直到找到最远的海洋地块
 * 3. 引入超级源点从而将原问题转化为单源bfs -- 最短路， O(n ^ 2)
 * 具体实现上，通过一个队列，把它所能到点（真实源点）进行入队，然后再进行常规的BFS
 */
public class Q1162_地图分析 {
    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private final int WATER = 0;
    private final int LAND = 1;
    int n;

    public int maxDistance(int[][] grid) {
        n = grid.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == WATER) {
                    ans = ans > getDistance(grid, i, j) ? ans : getDistance(grid, i, j);
                }
            }
        }

        return ans;
    }

    private int getDistance(int[][] grid, int row, int col) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col, 0});
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int currRow = pos[0] + dir[0];
                int currCol = pos[1] + dir[1];
                if (currRow < 0 || currRow >= n || currCol < 0 || currCol >= n) {
                    continue;
                }
                if (!visited[currRow][currCol]) {
                    visited[currRow][currCol] = true;
                    queue.offer(new int[]{currRow, currCol, pos[2] + 1});
                    if (grid[currRow][currCol] == LAND) {
                        return pos[2] + 1;
                    }
                }
            }
        }

        return -1;
    }

    public int maxDistance2(int[][] grid) {
        n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == LAND) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        boolean hasOcean = false;
        int[] pos = null;
        while (!queue.isEmpty()) {
            pos = queue.poll();
            for (int[] dir : dirs) {
                int currRow = pos[0] + dir[0];
                int currCol = pos[1] + dir[1];
                if (currRow < 0 || currRow >= n || currCol < 0 || currCol >= n || grid[currRow][currCol] != WATER) {
                    continue;
                }
                hasOcean = true;
                grid[currRow][currCol] = grid[pos[0]][pos[1]] + 1;
                queue.offer(new int[]{currRow, currCol});
            }
        }

        return pos == null || !hasOcean ? -1 : grid[pos[0]][pos[1]] - 1;
    }

    public int maxDistance3(int[][] grid) {
        n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == LAND) {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;
                }
            }
        }

        int ans = -1;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int row = pos[0];
            int col = pos[1];
            int step = Math.max(grid[row][col], 0);
            for (int[] dir : dirs) {
                int currRow = row + dir[0];
                int currCol = col + dir[1];
                if (currRow < 0 || currRow >= n || currCol < 0 || currCol >= n || grid[currRow][currCol] != WATER) {
                    continue;
                }
                queue.offer(new int[]{currRow, currCol});
                grid[currRow][currCol] = step + 1;
                ans = Math.max(ans, step + 1);
            }
        }

        return ans;
    }
}
