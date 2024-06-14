package Matrix;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2024/05/13
 * @file M994_腐烂的橘子.java
 * <p>
 * 思路
 * bfs模拟，判连同分量
 * <p>
 * 注：此题的题干没有描述，观察测试用例可知可有多个起点
 */
public class M994_腐烂的橘子 {
    private int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private final int FRESH_ORANGE = 1, ROT_ORANGE = 2;
    private Queue<int[]> q = new ArrayDeque<>();

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == ROT_ORANGE) {
                    q.add(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == FRESH_ORANGE) {
                    grid[nx][ny] = grid[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = grid[i][j];
                if (t == FRESH_ORANGE) {
                    return -1;
                }
                ans = Math.max(ans, t);
            }
        }

        return Math.max(ans - ROT_ORANGE, 0);
    }
}
