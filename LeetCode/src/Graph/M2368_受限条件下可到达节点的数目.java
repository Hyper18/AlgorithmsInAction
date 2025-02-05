package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/03/04
 * @file M2368_受限条件下可到达节点的数目.java
 * <p>
 * 思路
 * dfs，使用未受限结点建图
 */
public class M2368_受限条件下可到达节点的数目 {
    List<Integer>[] g;
    boolean[] isRestricted;
    int ans;

    private void init(int n, int[] restricted) {
        isRestricted = new boolean[n];
        for (int i : restricted) {
            isRestricted[i] = true;
        }
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        init(n, restricted);
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (!isRestricted[x] && !isRestricted[y]) {
                g[x].add(y);
                g[y].add(x);
            }
        }
        dfs(0, -1);

        return ans;
    }

    private void dfs(int x, int fa) {
        ans++;
        for (int y : g[x]) {
            if (y != fa) {
                dfs(y, x);
            }
        }
    }
}
