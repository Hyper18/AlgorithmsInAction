package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2024/11/19
 * @file M3243_新增道路查询后的最短距离I.java
 * <p>
 * 思路
 * 单源最短路
 * 初始情况下，需要添加n-1条边
 */
public class M3243_新增道路查询后的最短距离I {
    private final int N = 510, M = N << 1, INF = 0x3f3f3f3f;
    private int[] h = new int[N], e = new int[M], ne = new int[M];
    private int[] d = new int[N];
    private int idx;

    private void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int m = queries.length;
        Arrays.fill(h, -1);
        int[] res = new int[m];
        for (int i = 1; i < n; i++) {
            addEdge(i - 1, i);
        }
        for (int i = 0; i < m; i++) {
            boolean[] vis = new boolean[n];
            addEdge(queries[i][0], queries[i][1]);
            res[i] = dijkstra(vis, n - 1);
        }

        return res;
    }

    private int dijkstra(boolean[] vis, int n) {
        Arrays.fill(d, INF);
        d[0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(n, Comparator.comparingInt(a -> a[1]));
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int u = p[0], dis = p[1];
            if (vis[u]) {
                continue;
            }
            vis[u] = true;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] > dis + 1) {
                    d[j] = dis + 1;
                }
                q.offer(new int[]{j, d[j]});
            }
        }

        return d[n] == INF ? -1 : d[n];
    }
}
