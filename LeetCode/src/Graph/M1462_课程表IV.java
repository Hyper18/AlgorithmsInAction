package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2023/09/12
 * @file M1462_课程表IV.java
 * <p>
 * 邻接表建有向图，拓扑排序
 * 裸题参Q848，Q207
 */
public class M1462_课程表IV {
    final int M = 100 + 5, N = M * (M - 1) / 2;
    int[] h = new int[N], e = new int[N], ne = new int[N];
    int[] d = new int[N], q = new int[N];
    boolean[][] f = new boolean[M][M];
    int n, m, idx;

    private void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        n = numCourses;
        m = prerequisites.length;
        Arrays.fill(h, -1);
        for (int[] p : prerequisites) {
            int pre = p[0], cur = p[1];
            addEdge(pre, cur);
            d[cur]++;
        }
        topSort();
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(f[q[0]][q[1]]);
        }

        return res;
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
                f[u][j] = true;
                for (int k = 0; k < n; k++) {
                    f[k][j] |= f[k][u];
                }
                if (--d[j] == 0) {
                    q[++tt] = j;
                }
            }
        }

        return tt == n - 1;
    }
}
