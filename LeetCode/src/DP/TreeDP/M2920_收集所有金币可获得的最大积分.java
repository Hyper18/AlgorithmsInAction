package DP.TreeDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2025/01/23
 * @file M2920_收集所有金币可获得的最大积分.java
 */
public class M2920_收集所有金币可获得的最大积分 {
    private List<Integer>[] g;
    private int[][] memo;
    private int[] coins;
    private int k;

    public int maximumPoints(int[][] edges, int[] coins, int k) {
        this.coins = coins;
        this.k = k;
        int n = coins.length;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        memo = new int[n][14];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(0, 0, -1);
    }

    private int dfs(int i, int t, int p) {
        if (memo[i][t] != -1) {
            return memo[i][t];
        }
        int[] res = new int[]{(coins[i] >> t) - k, coins[i] >> (t + 1)};
        for (int j : g[i]) {
            if (j == p) {
                continue;
            }
            res[0] += dfs(j, t, i);
            if (t < 13) {
                res[1] += dfs(j, t + 1, i);
            }
        }

        return memo[i][t] = Math.max(res[0], res[1]);
    }
}
