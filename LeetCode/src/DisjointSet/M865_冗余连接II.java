package DisjointSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hyperspace
 * @date 2024/10/28
 * @file M865_冗余连接II.java
 * <p>
 * 思路@ylb
 * 并查集
 * 先找入度为2的节点，选择一条边删去
 * 若不存在，再判联通性找有向图
 */
public class M865_冗余连接II {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] in = new int[n];
        for (int[] e : edges) {
            in[e[1] - 1]++;
        }
        List<Integer> dup = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (in[edges[i][1] - 1] == 2) {
                dup.add(i);
            }
        }
        UnionFind uf = new UnionFind(n);
        if (!dup.isEmpty()) {
            for (int i = 0; i < n; i++) {
                if (i == dup.get(1)) {
                    continue;
                }
                if (!uf.union(edges[i][0] - 1, edges[i][1] - 1)) {
                    return edges[dup.get(0)];
                }
            }
            return edges[dup.get(1)];
        }
        for (int i = 0; ; i++) {
            if (!uf.union(edges[i][0] - 1, edges[i][1] - 1)) {
                return edges[i];
            }
        }
    }

    class UnionFind {
        private int[] p;
        private int[] size;

        public UnionFind(int n) {
            p = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        public boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) {
                return false;
            }
            if (size[pa] > size[pb]) {
                p[pb] = pa;
                size[pa] += size[pb];
            } else {
                p[pa] = pb;
                size[pb] += size[pa];
            }
            return true;
        }

        public int size(int root) {
            return size[root];
        }
    }
}
