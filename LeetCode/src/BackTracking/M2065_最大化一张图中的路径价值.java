package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/07/01
 * @file M2065_最大化一张图中的路径价值.java
 * <p>
 * 思路
 * 邻接矩阵建图，回溯
 * 数据量限制了每个节点至多有四条边
 * 最多是在树深11的四叉树上递归
 */
public class M2065_最大化一张图中的路径价值 {
    private final int N = 1010;
    private List<int[]>[] g = new List[N];
    private boolean[] vis = new boolean[N];
    private int[] values;
    private int maxTime;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.values = values;
        this.maxTime = maxTime;
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1], c = e[2];
            g[a].add(new int[]{b, c});
            g[b].add(new int[]{a, c});
        }
        vis[0] = true;

        return dfs(0, 0, values[0]);
    }

    private int dfs(int u, int t, int sum) {
        int ans = u == 0 ? sum : 0;
        for (int[] e : g[u]) {
            int v = e[0], c = e[1];
            if (t + c > maxTime) {
                continue;
            }
            if (vis[v]) {
                ans = Math.max(ans, dfs(v, t + c, sum));
            } else {
                vis[v] = true;
                ans = Math.max(ans, dfs(v, t + c, sum + values[v]));
                vis[v] = false;
            }
        }

        return ans;
    }
}
