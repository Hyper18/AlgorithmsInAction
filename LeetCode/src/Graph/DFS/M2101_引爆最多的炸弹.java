package Graph.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/07/22
 * @file M2101_引爆最多的炸弹.java
 * <p>
 * 思路
 * 邻接矩阵建单向图，dfs
 * <p>
 * 注意爆int
 */
public class M2101_引爆最多的炸弹 {
    private boolean[] vis;
    List<Integer>[] g;

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i && isWithin(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1], bombs[i][2])) {
                    g[i].add(j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            vis = new boolean[n];
            ans = Math.max(ans, dfs(i));
        }

        return ans;
    }

    private int dfs(int i) {
        vis[i] = true;
        int cnt = 1;
        for (int j : g[i]) {
            if (!vis[j]) {
                cnt += dfs(j);
            }
        }

        return cnt;
    }

    private boolean isWithin(long x1, long y1, long x2, long y2, long r) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= r * r;
    }
}
