package DP.TreeDP;

import java.util.Arrays;

/**
 * @author Hyper
 * @date 2023/07/16
 * @file M834_树中距离之和.java
 * <p>
 * 思路
 * 树形dp
 * 链式向前星建无向图，相邻节点间隔均为1
 * 参考官解，先计算节点数目
 * 再依次计算本节点到其余各节点距离
 */
public class M834_树中距离之和 {
    int[] h, e, ne;
    int[] d, nums;
    int n, idx;

    void init() {
        h = new int[n];
        e = new int[n << 1];
        ne = new int[n << 1];
        d = new int[n];
        nums = new int[n];
        Arrays.fill(h, -1);
        Arrays.fill(nums, 1);
    }

    void addEdge(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        init();
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            addEdge(a, b);
            addEdge(b, a);
        }
        dfs(0, -1);
        dfs2(0, -1);

        return d;
    }

    public void dfs(int u, int par) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == par) {
                continue;
            }
            dfs(v, u);
            nums[u] += nums[v];
            d[u] += d[v] + nums[v];
        }
    }

    public void dfs2(int u, int par) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == par) {
                continue;
            }
            d[v] = d[u] - nums[v] + n - nums[v];
            dfs2(v, u);
        }
    }
}
