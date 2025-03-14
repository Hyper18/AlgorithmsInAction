package Graph;

/**
 * @author Hyper
 * @date 2024/04/16
 * @file M924_尽量减少恶意软件的传播.java
 * <p>
 * 思路
 * 并查集
 * <p>
 * 待回看
 */
public class M924_尽量减少恶意软件的传播 {
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

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        int ans = n;
        int mi = n, mx = 0;
        int[] cnt = new int[n];
        for (int x : initial) {
            cnt[uf.find(x)]++;
            mi = Math.min(mi, x);
        }

        for (int x : initial) {
            int root = uf.find(x);
            if (cnt[root] == 1) {
                int sz = uf.size(root);
                if (sz > mx || (sz == mx && x < ans)) {
                    ans = x;
                    mx = sz;
                }
            }
        }

        return ans == n ? mi : ans;
    }
}
