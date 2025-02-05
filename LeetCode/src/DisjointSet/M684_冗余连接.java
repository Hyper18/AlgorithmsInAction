package DisjointSet;

/**
 * @author Hyper
 * @date 2024/10/27
 * @file M684_冗余连接.java
 * <p>
 * 思路
 * 并查集
 * 若两边属于相同的连通分量，则成环，返回结果
 * 若两边属于不同的连通分量，合并
 */
public class M684_冗余连接 {
    private int[] par;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            par[i] = i;
        }
        for (int[] e : edges) {
            if (find(e[0]) == find(e[1])) {
                return e;
            }
            union(e[0], e[1]);
        }

        return new int[]{};
    }

    private int find(int idx) {
        if (par[idx] != idx) {
            par[idx] = find(par[idx]);
        }
        return par[idx];
    }

    private void union(int idx1, int idx2) {
        par[find(idx1)] = find(idx2);
    }
}
