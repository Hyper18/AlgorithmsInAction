package Graph;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/04/15
 * @file M1042_不邻接植花.java
 * <p>
 * 思路
 * 类染色法（见Q860）
 * 先建图后深搜
 * 条件变为：
 * 1）j点的颜色与u点相同
 * 2）j点尚未染色
 * 判断染c=1，c=2，c=3色是否合适
 */
public class M1042_不邻接植花 {
    private int N = (int) 1e4 + 10, M = N * 3;
    private int[] h = new int[N], e = new int[M], ne = new int[M];
    private int[] ans = new int[N];
    private int idx;

    private void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        Arrays.fill(h, -1);
        for (int[] p : paths) {
            int a = p[0], b = p[1];
            addEdge(a, b);
            addEdge(b, a);
        }

        for (int i = 1; i <= n; i++) {
            if (ans[i] == 0) {
                dfs(i, 1);
            }
        }

        return Arrays.copyOfRange(ans, 1, n + 1);
    }

    private boolean dfs(int u, int c) {
        ans[u] = c;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (ans[j] == c) {
                return false;
            }
            if (ans[j] == 0 && !dfs(j, ((c + 1 - 1) % 4) + 1) && !dfs(j, ((c + 2 - 1) % 4) + 1) && !dfs(j, ((c + 3 - 1) % 4) + 1)) {
                return false;
            }
        }

        return true;
    }
}
