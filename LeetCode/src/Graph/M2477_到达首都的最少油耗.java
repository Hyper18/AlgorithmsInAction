package Graph;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/12/05
 * @file M2477_到达首都的最少油耗.java
 * <p>
 * 思路
 * dfs
 */
public class M2477_到达首都的最少油耗 {
    final int N = 100010, M = N * 2;
    int[] h = new int[N], e = new int[M], ne = new int[M];
    int idx;
    long ans = 0;

    private void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        Arrays.fill(h, -1);
        for (int[] road : roads) {
            int a = road[0], b = road[1];
            addEdge(a, b);
            addEdge(b, a);
        }
        dfs(0, -1, seats);

        return ans;
    }

    private int dfs(int u, int c, int t) {
        int cnt = 1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == c) {
                continue;
            }
            cnt += dfs(j, u, t);
        }
        if (u != 0) {
            ans += Math.ceil(cnt * 1.0 / t);
        }

        return cnt;
    }
}
