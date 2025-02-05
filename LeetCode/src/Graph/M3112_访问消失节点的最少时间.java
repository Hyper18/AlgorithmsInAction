package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyper
 * @date 2024/07/18
 * @file M3112_访问消失节点的最少时间.java
 */
public class M3112_访问消失节点的最少时间 {
    final int M = (int) 1e5 + 7, N = M * 2, INF = 0x3f3f3f3f;
    int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N];
    int[] d = new int[N];
    boolean[] vis = new boolean[N];
    int n, idx;
    int[] disappear;

    private void addEdge(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        this.n = n;
        this.disappear = disappear;
        Arrays.fill(h, -1);
        for (int[] e : edges) {
            int a = e[0], b = e[1], c = e[2];
            addEdge(a, b, c);
            addEdge(b, a, c);
        }
        dijkstra();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = d[i] == INF ? -1 : d[i];
        }

        return res;
    }

    private void dijkstra() {
        Arrays.fill(d, INF);
        d[0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int t = p[1];
            if (vis[t]) {
                continue;
            }
            vis[t] = true;
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[t] + w[i] < d[j] && disappear[j] > d[t] + w[i]) {
                    d[j] = d[t] + w[i];
                    q.offer(new int[]{d[j], j});
                }
            }
        }
    }
}
