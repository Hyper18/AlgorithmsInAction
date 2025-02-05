package Graph;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2024/11/14
 * @file M3249_统计好节点的数目.java
 * <p>
 * 思路
 * 无向图dfs
 */
public class M3249_统计好节点的数目 {
    final int N = (int) 1e5 + 7, M = N << 1;
    int[] h = new int[N], e = new int[M], ne = new int[M];
    int idx, ans;

    void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    int dfs(int u, int par) {
        int sum = 0, last = -1;
        boolean flag = true;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == par) {
                continue;
            }
            int cur = dfs(j, u);
            if (last == -1) {
                last = cur;
            } else if (last != cur) {
                flag = false;
            }
            sum += cur;
        }
        if (flag) {
            ans++;
        }

        return sum + 1;
    }

    public int countGoodNodes(int[][] edges) {
        Arrays.fill(h, -1);
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            addEdge(a, b);
            addEdge(b, a);
        }
        dfs(0, -1);

        return ans;
    }
}
