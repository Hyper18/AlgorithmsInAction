package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hyper
 * @date 2024/02/27
 * @file M2867_统计树中的合法路径数目.java
 * <p>
 * 思路
 * dfs+素数筛
 * <p>
 * 待回看
 */
public class M2867_统计树中的合法路径数目 {
    private final static int N = (int) 1e5;
    private final static boolean[] np = new boolean[N + 1]; // 质数=false 非质数=true

    static {
        np[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!np[i]) {
                for (int j = i * i; j <= N; j += i) {
                    np[j] = true;
                }
            }
        }
    }

    public long countPaths(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        long ans = 0;
        int[] size = new int[n + 1];
        List<Integer> nodes = new ArrayList<>();
        for (int x = 1; x <= n; x++) {
            if (np[x]) { // 跳过非质数
                continue;
            }
            int sum = 0;
            for (int y : g[x]) { // 质数 x 把这棵树分成了若干个连通块
                if (!np[y]) {
                    continue;
                }
                if (size[y] == 0) { // 尚未计算过
                    nodes.clear();
                    dfs(y, -1, g, nodes); // 遍历 y 所在连通块，在不经过质数的前提下，统计有多少个非质数
                    for (int z : nodes) {
                        size[z] = nodes.size();
                    }
                }
                // 这 size[y] 个非质数与之前遍历到的 sum 个非质数，两两之间的路径只包含质数 x
                ans += (long) size[y] * sum;
                sum += size[y];
            }
            ans += sum; // 从 x 出发的路径
        }

        return ans;
    }

    private void dfs(int x, int fa, List<Integer>[] g, List<Integer> nodes) {
        nodes.add(x);
        for (int y : g[x]) {
            if (y != fa && np[y]) {
                dfs(y, x, g, nodes);
            }
        }
    }
}
