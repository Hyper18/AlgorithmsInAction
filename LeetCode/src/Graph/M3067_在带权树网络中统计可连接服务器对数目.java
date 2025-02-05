package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/06/04
 * @file M3067_在带权树网络中统计可连接服务器对数目.java
 * <p>
 * 思路
 * 邻接矩阵建双向图，dfs枚举根
 */
public class M3067_在带权树网络中统计可连接服务器对数目 {
    private final int N = 1010, M = N * 2;
    private List<int[]>[] g = new ArrayList[M];
    private int signalSpeed;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        this.signalSpeed = signalSpeed;
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w});
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int pre = 0;
            for (int[] e : g[i]) {
                int cnt = dfs(e[0], i, e[1] % signalSpeed);
                res[i] += pre * cnt;
                pre += cnt;
            }
        }

        return res;
    }

    private int dfs(int u, int par, int cur) {
        int res = 0;
        if (cur == 0) {
            res++;
        }
        for (int[] e : g[u]) {
            int v = e[0], w = e[1];
            if (v != par) {
                res += dfs(v, u, (w + cur) % signalSpeed);
            }
        }

        return res;
    }
}
