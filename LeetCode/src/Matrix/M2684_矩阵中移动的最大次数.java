package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/03/16
 * @file M2684_矩阵中移动的最大次数.java
 * <p>
 * 思路
 * bfs
 */
public class M2684_矩阵中移动的最大次数 {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] vis = new int[m];
        Arrays.fill(vis, -1);
        List<Integer> q = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            q.add(i);
        }
        for (int cnt = 0; cnt < n - 1; cnt++) {
            List<Integer> li = new ArrayList<>();
            for (int i : q) {
                for (int j = Math.max(i - 1, 0); j < Math.min(i + 2, m); j++) {
                    if (vis[j] != cnt && grid[j][cnt + 1] > grid[i][cnt]) {
                        vis[j] = cnt;
                        li.add(j);
                    }
                }
            }
            if (li.isEmpty()) {
                return cnt;
            }
            q = li;
        }

        return n - 1;
    }
}
