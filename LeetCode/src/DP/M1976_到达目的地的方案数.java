package DP;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Hyper
 * @date 2024/03/05
 * @file M1976_到达目的地的方案数.java
 * <p>
 * 思路
 * 先用Dijkstra求最短路，再重新建图统计入度，最后DP拓扑排序统计方案数
 * 数据量原因，直接用邻接矩阵建图
 * <p>
 * 待回看
 * 注意爆int和INF的取值
 */
public class M1976_到达目的地的方案数 {
    final int N = 205, MOD = (int) 1e9 + 7;
    final long INF = (long) 1e12;
    int[][] g = new int[N][N];
    int[] in = new int[N];
    long[] d = new long[N];
    boolean[] vis = new boolean[N];
    int n;

    public int countPaths(int n, int[][] roads) {
        this.n = n;
        for (int[] r : roads) {
            int a = r[0], b = r[1], c = r[2];
            g[a][b] = g[b][a] = c;
        }

        dijkstra();

        for (int[] r : roads) {
            int a = r[0], b = r[1], c = r[2];
            g[a][b] = g[b][a] = 0;
            if (d[a] + c == d[b]) {
                g[a][b] = c;
                in[b]++;
            } else if (d[b] + c == d[a]) {
                g[b][a] = c;
                in[a]++;
            }
        }

        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                d.addLast(i);
            }
        }
        int[] f = new int[n];
        f[0] = 1;
        while (!d.isEmpty()) {
            int x = d.pollFirst();
            for (int i = 0; i < n; i++) {
                if (g[x][i] == 0) {
                    continue;
                }
                f[i] = (f[i] + f[x]) % MOD;
                if (--in[i] == 0) {
                    d.addLast(i);
                }
            }
        }

        return f[n - 1];
    }

    private void dijkstra() {
        Arrays.fill(d, INF);
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (t == -1 || d[t] > d[j])) {
                    t = j;
                }
            }
            vis[t] = true;
            for (int j = 0; j < n; j++) {
                if (g[t][j] == 0) {
                    continue;
                }
                d[j] = Math.min(d[j], d[t] + g[t][j]);
            }
        }
    }
}
