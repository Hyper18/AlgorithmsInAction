package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hyperspace
 * @date 2024/11/25
 * @file M743_网络延迟时间.java
 * <p>
 * 思路
 * 有向图单源最短路
 * 约束条件：
 * 1）所有节点均被访问
 * 2）每次更新最短路的长度，直到满足1
 * <p>
 * 注：和板子不同的是，本题的写法不包含vis数组
 * 因此后续在新加入节点时，只考虑满足d[j] > dis + w[i]的情况
 */
public class M743_网络延迟时间 {
    private final int N = 6010, INF = 0x3f3f3f3f;
    private int[] h = new int[N], e = new int[N], ne = new int[N], w = new int[N];
    private int[] d = new int[N];
    private int idx;

    private void addEdge(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Arrays.fill(h, -1);
        for (int[] t : times) {
            addEdge(t[0], t[1], t[2]);
        }
        return dijkstra(k, n);
    }

    private int dijkstra(int k, int n) {
        Arrays.fill(d, INF);
        d[k] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(n, Comparator.comparingInt(a -> a[1]));
        q.offer(new int[]{k, 0});
        int ans = 0, cnt = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int u = p[0], dis = p[1];
            if (dis > d[u]) {
                continue;
            }
            ans = dis;
            cnt++;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] > dis + w[i]) {
                    d[j] = dis + w[i];
                    q.offer(new int[]{j, d[j]});
                }
            }
        }

        return cnt < n ? -1 : ans;
    }
}
