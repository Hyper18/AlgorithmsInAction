package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2023/11/09
 * @file M2258_逃离火灾.java
 * <p>
 * 思路@灵茶山艾府
 * bfs
 * 注：需要考虑人和火同时到达的情况
 */
public class M2258_逃离火灾 {
    final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;

    public int maximumMinutes(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[] res = bfs(grid, new ArrayList<>(Collections.singletonList(new int[]{0, 0})));
        int manToHouseTime = res[0], m1 = res[1], m2 = res[2];
        if (manToHouseTime < 0) {
            return -1;
        }

        List<int[]> firePos = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    firePos.add(new int[]{i, j});
                }
            }
        }
        res = bfs(grid, firePos);
        int fireToHouseTime = res[0], f1 = res[1], f2 = res[2];
        if (fireToHouseTime < 0) {
            return (int) 1e9;
        }

        int d = fireToHouseTime - manToHouseTime;
        if (d < 0) {
            return -1;
        }

        if (m1 != -1 && m1 + d < f1 || m2 != -1 && m2 + d < f2) {
            return d;
        }
        return d - 1;
    }

    private int[] bfs(int[][] grid, List<int[]> q) {
        int[][] times = new int[m][n];
        for (int[] time : times) {
            Arrays.fill(time, -1);
        }
        for (int[] p : q) {
            times[p[0]][p[1]] = 0;
        }
        for (int t = 1; !q.isEmpty(); t++) {
            List<int[]> tmp = q;
            q = new ArrayList<>();
            for (int[] p : tmp) {
                for (int[] d : dirs) {
                    int x = p[0] + d[0], y = p[1] + d[1];
                    if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] == 0 && times[x][y] < 0) {
                        times[x][y] = t;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }

        return new int[]{times[m - 1][n - 1], times[m - 1][n - 2], times[m - 2][n - 1]};
    }
}
