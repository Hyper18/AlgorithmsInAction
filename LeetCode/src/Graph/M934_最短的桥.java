package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2022/10/25
 * <p>
 * 思路
 * 写完发现已经是第二次写。。两次bfs
 */
public class M934_最短的桥 {
    final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;

    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        List<int[]> island = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                q.offer(new int[]{i, j});
                grid[i][j] = 2;
                while (!q.isEmpty()) {
                    int[] pos = q.poll();
                    int x = pos[0], y = pos[1];
                    island.add(pos);
                    for (int[] d : dirs) {
                        int nx = x + d[0], ny = y + d[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                            q.offer(new int[]{nx, ny});
                            grid[nx][ny] = 2;
                        }
                    }
                }

                for (int[] pos : island) {
                    q.offer(pos);
                }
                int step = 0;
                while (!q.isEmpty()) {
                    // 必须预先存储原长度
                    int len = q.size();
                    for (int k = 0; k < len; k++) {
                        int[] pos = q.poll();
                        int x = pos[0], y = pos[1];
                        for (int[] d : dirs) {
                            int nx = x + d[0], ny = y + d[1];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (grid[nx][ny] == 0) {
                                    q.offer(new int[]{nx, ny});
                                    grid[nx][ny] = 2;
                                } else if (grid[nx][ny] == 1) {
                                    return step;
                                }
                            }
                        }
                    }
                    step++;
                }
            }
        }

        return 0;
    }
}
