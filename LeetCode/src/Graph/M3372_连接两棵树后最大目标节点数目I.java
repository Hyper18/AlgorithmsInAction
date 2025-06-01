package Graph;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2025/05/28
 * @file M3372_连接两棵树后最大目标节点数目I.java
 * <p>
 * 思路
 * 贪心，bfs
 */
public class M3372_连接两棵树后最大目标节点数目I {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length, m = edges2.length;
        int[] res = new int[n + 1];
        if (k == 0) {
            Arrays.fill(res, 1);
            return res;
        }
        int mx = 0;
        List<Integer>[] g = build(edges2);
        for (int i = 0; i <= m; i++) {
            mx = Math.max(mx, bfs(g, i, k));
        }
        g = build(edges1);
        for (int i = 0; i <= n; i++) {
            res[i] = bfs(g, i, k + 1) + mx;
        }

        return res;
    }

    private List<Integer>[] build(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] item : edges) {
            g[item[0]].add(item[1]);
            g[item[1]].add(item[0]);
        }

        return g;
    }

    private int bfs(List<Integer>[] g, int st, int k) {
        int n = g.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        vis[st] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(st);
        int res = 1;
        while (!q.isEmpty()) {
            int p = q.poll(), d = vis[p];
            if (d + 1 >= k) {
                continue;
            }
            for (int target : g[p]) {
                if (vis[target] == -1) {
                    vis[target] = d + 1;
                    q.add(target);
                    res++;
                }
            }
        }

        return res;
    }
}
