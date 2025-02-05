package Graph;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/09/09
 * @file M207_课程表.java
 * <p>
 * 思路
 * 邻接表建有向图，拓扑排序
 * 裸题参Q848
 */
public class M207_课程表 {
    final int N = 5000 + 10;
    int[] h = new int[N], e = new int[N], ne = new int[N];
    int[] d = new int[N], q = new int[N];
    int n, m, idx;

    private void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        m = prerequisites.length;
        Arrays.fill(h, -1);
        for (int[] p : prerequisites) {
            int cur = p[0], pre = p[1];
            addEdge(pre, cur);
            d[cur]++;
        }

        return topSort();
    }

    private boolean topSort() {
        int hh = 0, tt = -1;
        for (int i = 0; i < n; i++) {
            if (d[i] == 0) {
                q[++tt] = i;
            }
        }

        while (hh <= tt) {
            int u = q[hh++];
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--d[j] == 0) {
                    q[++tt] = j;
                }
            }
        }

        return tt == n - 1;
    }
}
