package Graph.DFS;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/07/22
 * @file M2101_引爆最多的炸弹2.java
 */
public class M2101_引爆最多的炸弹2 {
    final int N = 10010;
    int[] h = new int[N], e = new int[N], ne = new int[N];
    boolean[] vis;
    int idx;

    private void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        Arrays.fill(h, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i && isWithin(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1], bombs[i][2])) {
                    addEdge(i, j);
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

    private int dfs(int u) {
        vis[u] = true;
        int cnt = 1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
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
