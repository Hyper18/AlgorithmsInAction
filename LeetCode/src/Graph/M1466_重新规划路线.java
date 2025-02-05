package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2023/12/07
 * @file M1466_重新规划路线.java
 * <p>
 * 思路
 * dfs，从0开始向外依次找反向边
 */
public class M1466_重新规划路线 {
    List<int[]>[] g;

    public int minReorder(int n, int[][] connections) {
        g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] conn : connections) {
            int a = conn[0], b = conn[1];
            g[a].add(new int[]{b, 1});
            g[b].add(new int[]{a, 0});
        }

        return dfs(0, -1);
    }

    private int dfs(int u, int last) {
        int ans = 0;
        for (int[] e : g[u]) {
            int b = e[0], a = e[1];
            if (b != last) {
                ans += a + dfs(b, u);
            }
        }

        return ans;
    }
}
