package Graph.Bipartite;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2022/10/16
 * <p>
 * 思路
 * 染色法判定二分图（裸）
 * 注：无向图开2倍，太久没写图论了。。
 */
public class M886_可能的二分法 {
    final int N = 2010, M = 10010 * 2;
    int[] h = new int[N], e = new int[M], ne = new int[M];
    int[] color = new int[N];
    int idx;

    public void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Arrays.fill(h, -1);
        for (int[] d : dislikes) {
            int a = d[0], b = d[1];
            addEdge(a, b);
            addEdge(b, a);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int u, int c) {
        color[u] = c;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (color[j] == c) {
                return false;
            }
            if (color[j] == 0 && !dfs(j, 3 - c)) {
                return false;
            }
        }

        return true;
    }
}
