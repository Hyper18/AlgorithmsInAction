package Design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2024/03/26
 * @file M2642_设计可以求最短路径的图类.java
 * <p>
 * 思路
 * 最短路裸
 * spfa
 * <p>
 * 待回看，再分别写两个node1到node2的dijkstra和floyd
 */
public class M2642_设计可以求最短路径的图类 {
    class Graph {
        final int N = (int) 1e4, INF = 0x3f3f3f3f;
        private int[] h = new int[N], e = new int[N], ne = new int[N];
        private int[] d = new int[N], w = new int[N];
        private boolean[] vis = new boolean[N];
        int n, idx;

        public Graph(int n, int[][] edges) {
            this.n = n;
            Arrays.fill(h, -1);
            for (int[] e : edges) {
                addEdge(e);
            }
        }

        public void addEdge(int[] edge) {
            int a = edge[0], b = edge[1], c = edge[2];
            e[idx] = b;
            w[idx] = c;
            ne[idx] = h[a];
            h[a] = idx++;
        }

        public int shortestPath(int node1, int node2) {
            Arrays.fill(d, INF);
            d[node1] = 0;
            Queue<Integer> q = new LinkedList<>();
            q.offer(node1);
            vis[node1] = true;
            while (!q.isEmpty()) {
                int u = q.poll();
                vis[u] = false;
                for (int i = h[u]; i != -1; i = ne[i]) {
                    int j = e[i];
                    if (d[j] > d[u] + w[i]) {
                        d[j] = d[u] + w[i];
                        if (vis[j]) {
                            continue;
                        }
                        q.offer(j);
                        vis[j] = true;
                    }
                }
            }

            return d[node2] == INF ? -1 : d[node2];
        }
    }

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
}
