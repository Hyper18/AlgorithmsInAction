package Graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2022/03/06，2025/05/20
 * <p>
 * 思路
 * 1. dfs
 * 2. bfs
 */
public class Q200_岛屿数量 {
    class Solution {
        private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        private char[][] g;
        private int m, n;

        public int numIslands(char[][] grid) {
            g = grid;
            m = grid.length;
            n = grid[0].length;
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        dfs(i, j);
                        ans++;
                    }
                }
            }

            return ans;
        }

        private void dfs(int x, int y) {
            if (x < 0 || x >= m || y < 0 || y >= n || g[x][y] != '1') {
                return;
            }
            g[x][y] = '0';
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                dfs(nx, ny);
            }
        }
    }

    class Solution2 {
        private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        private char[][] g;
        private int m, n;

        public int numIslands(char[][] grid) {
            g = grid;
            m = grid.length;
            n = grid[0].length;
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i][j] == '1') {
                        bfs(i, j);
                        ans++;
                    }
                }
            }

            return ans;
        }

        private void bfs(int i, int j) {
            Deque<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{i, j});
            while (!q.isEmpty()) {
                int[] p = q.poll();
                int x = p[0], y = p[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || g[nx][ny] != '1') {
                        continue;
                    }
                    g[nx][ny] = '0';
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
